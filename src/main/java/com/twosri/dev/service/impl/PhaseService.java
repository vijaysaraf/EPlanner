package com.twosri.dev.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.twosri.dev.bean.Phase;
import com.twosri.dev.database.model.PhaseEntity;
import com.twosri.dev.database.repository.PhaseRepository;
import com.twosri.dev.service.IPhaseService;
import com.twosri.dev.service.cache.CacheManager;
import com.twosri.dev.util.CustomMessage;
import com.twosri.dev.util.ErrorCode;
import com.twosri.dev.util.ExceptionFactory;
import com.twosri.dev.util.Mode;

@Service
public class PhaseService implements IPhaseService {

	@Autowired
	PhaseRepository repository;

	@Autowired
	ModelMapper mMapper;

	@Autowired
	ExceptionFactory exceptionFactory;

	@Autowired
	CacheManager cacheManager;

	@Override
	public void delete(Phase deleted) {
		try {
			repository.delete(deleted.getId());
			cacheManager.updatePhases(Mode.DELETE, deleted.getId(), null);
		} catch (Exception e) {
			throw exceptionFactory.createException(ErrorCode.GENERIC,
					CustomMessage.getMessage(CustomMessage.GENERIC_ERROR, null), e);
		}
	}

	@Override
	public List<Phase> findAll() {
		List<PhaseEntity> entityList = repository.findAll();
		return entityList.stream().map(entity -> mMapper.map(entity, Phase.class)).collect(Collectors.toList());
	}

	@Override
	public Phase findOne(String id) {
		PhaseEntity entity = repository.findOne(id);
		return mMapper.map(entity, Phase.class);
	}

	@Override
	public Phase save(Phase toBeSaved) {
		validatePhase(toBeSaved);
		try {
			PhaseEntity entity = repository.save(mMapper.map(toBeSaved, PhaseEntity.class));
			cacheManager.updatePhases(Mode.ADD, entity.getId(), toBeSaved);
			return mMapper.map(entity, Phase.class);
		} catch (DuplicateKeyException e) {
			throw exceptionFactory.createException(ErrorCode.VALIDATION,
					CustomMessage.getMessage(CustomMessage.PHASE_SEQUENCE_ALREADY_EXIST,
							new String[] { toBeSaved.getName(), String.valueOf(toBeSaved.getSequence()) }),
					e);
		} catch (Exception e) {
			throw exceptionFactory.createException(ErrorCode.GENERIC,
					CustomMessage.getMessage(CustomMessage.GENERIC_ERROR, null), e);
		}
	}

	private void validatePhase(Phase toBeSaved) {
		String msg = "";
		if (toBeSaved.getName() == null || toBeSaved.getName().trim().length() <= 0) {
			msg = CustomMessage.getMessage(CustomMessage.PHASE_NAME_IS_NOT_VALID, new String[] { toBeSaved.getName() });
		} else if (toBeSaved.getSequence() == 0) {
			msg = CustomMessage.getMessage(CustomMessage.PHASE_SEQUENCE_NOT_VALID,
					new String[] { String.valueOf(toBeSaved.getSequence()) });
		}
		if (toBeSaved.getDefaultManPower() == 0) {
			msg = CustomMessage.getMessage(CustomMessage.PHASE_MAN_POWER_NOT_VALID,
					new String[] { String.valueOf(toBeSaved.getDefaultManPower()) });
		}
		if (!msg.equals("")) {
			throw exceptionFactory.createException(ErrorCode.VALIDATION, msg, null);
		}

	}

}
