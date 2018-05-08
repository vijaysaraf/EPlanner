package com.twosri.dev.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twosri.dev.bean.Calculation;
import com.twosri.dev.bean.Phase;
import com.twosri.dev.bean.Reference;
import com.twosri.dev.database.model.CalculationEntity;
import com.twosri.dev.database.repository.CalculationRepository;
import com.twosri.dev.service.ICalculationService;
import com.twosri.dev.service.cache.CacheManager;
import com.twosri.dev.util.CustomMessage;
import com.twosri.dev.util.ErrorCode;
import com.twosri.dev.util.ExceptionFactory;

@Service
public class CalculationService implements ICalculationService {

	@Autowired
	CalculationRepository repository;

	@Autowired
	ModelMapper mMapper;

	@Autowired
	ExceptionFactory exceptionFactory;

	@Autowired
	CacheManager cacheManager;

	@Override
	public void delete(Calculation deleted) {
		try {
			repository.delete(deleted.getId());
		} catch (Exception e) {
			throw exceptionFactory.createException(ErrorCode.GENERIC,
					CustomMessage.getMessage(CustomMessage.GENERIC_ERROR, null), e);
		}
	}

	@Override
	public List<Calculation> findAll() {
		List<CalculationEntity> entityList = repository.findAll();
		List<Calculation> calculations = entityList.stream().map(entity -> {
			Calculation calculation = mMapper.map(entity, Calculation.class);
			calculation.setProductName(cacheManager.getProduct(entity.getProductType()).getName());
			calculation.setPhaseName(cacheManager.getPhase(entity.getPhaseId()).getName());
			return calculation;
		}).collect(Collectors.toList());
		return calculations;
	}

	@Override
	public Calculation findOne(String id) {
		CalculationEntity entity = repository.findOne(id);
		return mMapper.map(entity, Calculation.class);
	}

	@Override
	public Calculation save(Calculation toBeSaved) {
		validateCalculation(toBeSaved);
		try {
			CalculationEntity entity = repository.save(mMapper.map(toBeSaved, CalculationEntity.class));
			return mMapper.map(entity, Calculation.class);
		} catch (Exception e) {
			throw exceptionFactory.createException(ErrorCode.GENERIC,
					CustomMessage.getMessage(CustomMessage.GENERIC_ERROR, null), e);
		}
	}

	private void validateCalculation(Calculation toBeSaved) {
		String msg = "";
		if (toBeSaved.getProductType() == null || toBeSaved.getProductType().trim().length() <= 0) {
			msg = CustomMessage.getMessage(CustomMessage.CALCULATION_PRODUCT_IS_NOT_VALID,
					new String[] { toBeSaved.getProductType() });
		} else if (toBeSaved.getPhaseId() == null || toBeSaved.getPhaseId().trim().length() <= 0
				|| toBeSaved.getPhaseId().trim().equals("0")) {
			msg = CustomMessage.getMessage(CustomMessage.CALCULATION_PHASE_IS_NOT_VALID,
					new String[] { toBeSaved.getPhaseId() });
		} else if (toBeSaved.getCalculatedManHours() == 0) {
			msg = CustomMessage.getMessage(CustomMessage.CALCULATION_MAN_HRS_IS_NOT_VALID,
					new String[] { String.valueOf(toBeSaved.getCalculatedManHours()) });
		} else {
			boolean isExisting = false;
			List<CalculationEntity> records = repository.findByProductTypeAndPhaseId(toBeSaved.getProductType(),
					toBeSaved.getPhaseId());
			if (!records.isEmpty()) {
				if (records.size() == 1) {
					if (toBeSaved.getId() == null || !records.get(0).getId().equals(toBeSaved.getId()))
						isExisting = true;
				} else
					isExisting = true; // Worst case
			}
			if (isExisting)
				msg = CustomMessage.getMessage(CustomMessage.CALCULATION_ENTRY_ALREADY_EXIST,
						new String[] { toBeSaved.getProductName(), toBeSaved.getPhaseName() });
		}
		if (!msg.equals("")) {
			throw exceptionFactory.createException(ErrorCode.VALIDATION, msg, null);
		}

	}

}
