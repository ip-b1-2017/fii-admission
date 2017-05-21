﻿function encodeImageFileAsURL(element) {
	var file = element.files[0];
	var reader = new FileReader();
	reader.readAsDataURL(file);
	var formData = new FormData();
	reader.onloadend = function() {
		var ex = (reader.result).split("+").join("%2B");
		formData.append(element.name, ex);
		$.ajax({
			url: "https://localhost:8090/form_save",
			type: "POST",
			cache: false,
			contentType: false,
			processData: false,
			data: formData})
				.done(function(e){
				    alert('Poza a fost adaugata in baza de date!');
		});
	}
}

function sendForm(formId){
	$.post(
		$(formId).attr("action"),
		$(formId).serialize()
	);
}

$(document).ready(function () {

    var navListItems = $('ul.setup-panel li a'),
        allWells = $('.setup-content');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
            $item = $(this).closest('li');

        if (!$item.hasClass('disabled')) {
            navListItems.closest('li').removeClass('active');
            $item.addClass('active');
            allWells.hide();
            $target.show();
        }
    });

    $('ul.setup-panel li.active a').trigger('click');

    // DEMO ONLY //
    $('#activate-step-2').on('click', function (e) {
        sendForm("#myform");
        $('ul.setup-panel li:eq(1)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
    });

    $('#activate-step-3').on('click', function (e) {
        sendForm("#myform2");
        $('ul.setup-panel li:eq(2)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-3"]').trigger('click');
    });
    $('#activate-step-4').on('click', function (e) {
        sendForm("#myform3");
        $('ul.setup-panel li:eq(3)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-4"]').trigger('click');
    });
    $('#activate-step-5').on('click', function (e) {
        $('ul.setup-panel li:eq(4)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-5"]').trigger('click');
    });
    $('#activate-step-6').on('click', function (e) {
        sendForm("#myform5");
        $('ul.setup-panel li:eq(5)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-6"]').trigger('click');
    });
    $('#activate-step-7').on('click', function (e) {
        sendForm("#myform6");
        $('ul.setup-panel li:eq(6)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-7"]').trigger('click');
    });
    $('#activate-step-8').on('click', function (e) {
        $('ul.setup-panel li:eq(7)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-8"]').trigger('click');
    });
    $('#finish-button').on('click', function (e) {
        sendForm("#myform8");
    })
});