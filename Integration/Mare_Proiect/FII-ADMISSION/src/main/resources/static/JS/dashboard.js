/**
 * Created by cosmin on 6/12/2017.
 */
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/modules/get_modules",
        async: false,
        contentType: "application/json",
        success: function(data,status) {
            $.each(data, function(index) {
                document.getElementById("myDropdown").innerHTML +=  '<a href="/modules/'+ data[index]+'/'+'">'+ data[index].substr(data[index].lastIndexOf(".")+1) +'</a>';

            });
        }
    });
});