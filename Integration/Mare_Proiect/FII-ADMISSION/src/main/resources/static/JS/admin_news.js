// <<<<<<< HEAD
var modal = document.getElementById('news_modal');
var btn = document.getElementById("news");

btn.onclick = function() {
    modal.style.display = "block";
    var x = document.getElementById("anuntP").innerHTML;
    document.getElementById("news_text").value = x;
}


function prost() {

    modal.style.display = "none";
    var x = document.getElementById("news_text").value;
    alert(x);
    document.getElementById("anuntP").innerHTML=x;
}

// =======
// var modal = document.getElementById('news_modal');
// var btn = document.getElementById("news");
// var span = document.getElementsByClassName("close")[0];

// btn.onclick = function() {
//     modal.style.display = "block";
// }

// span.onclick = function() {
//     modal.style.display = "none";
// }

// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }
// >>>>>>> d1851c1e32a56e867ae457a1c69d2d008c337cd2
