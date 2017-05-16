$(document).ready(function () {
        $.getJSON( "http://localhost:9999/model/candidati_formuri", {})
          .done(function( json ) {
            console.log( "JSON Data: " + json[0] );
          })
});