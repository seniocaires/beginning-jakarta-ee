$(function() {
	$('#dateFormat').val("yyyy-MM-dd HH:mm:ss.SSSXXX");
	$('#submitButton').click(function() {
		var fmt = $('#dateFormat').val();
		var url = "../webapi/date";
		$.ajax({
			method : "GET",
			url : url,
			data : {
				dateFormat : fmt
			}
		}).done(function(msg) {
			$('#errOutput').html(msg.errMsg);
			$('#dateOutput').html("Current date/time: " + msg.date);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			$('#errOutput').html("AJAX error: " + errorThrown);
		});
	});
})