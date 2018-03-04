jQuery(document).ready(function () {

	fire_ajax_submit();

});

function fire_ajax_submit() {

    var userdata = {}
    userdata["name"] = "Easun";//$("#username").val();
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/loadPO",
        data: JSON.stringify(userdata),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            

        }
    });

}