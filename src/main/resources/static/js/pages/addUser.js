/**
 * Created by vani on 20/4/16.
 */

//csrf tokens for ajax post
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

//adding csrf tokens in all ajax
$.ajaxSetup({
    beforeSend: function (xhr) {
        xhr.setRequestHeader(header, token);
    }
});



$(function () {

$('#id').val(0)

    $.ajax({
        url: '/app/role/list',
        type: 'GET',
        success: function (json) {

            var $el = $("#role");
            $el.empty(); // remove old options
            $el.append($("<option></option>"));
            $.each(json, function (value) {

                $el.append($("<option></option>")
                    .attr("value", json[value].id).text(json[value].roleName));
            });


        }
    })


    $('#userAdd').validate({
        rules: {
            fullname: {
                required: true

            },
            email: {
                required: true

            },
            password: {
                required: true
            },
            role: {
                required: true
            }
        },
        messages: {

            email: {
                required: "Enter an email"
            }
},


        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');

        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },

        submitHandler: function () {
            addUser();
        }

    });


});

function addUser() {


    var JsonData = {
        email: $('#email').val(),
        id: $('#id').val(),
        fullName: $('#fullname').val(),
        role: $('#role').val(),
        phoneNo: $('#phNo').val(),
        password: $('#password').val()

    };


    $.ajax({
        url: '/app/user/add/post',
        type: 'POST',
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(JsonData),
        success: function (data) {


        }
    });

}

