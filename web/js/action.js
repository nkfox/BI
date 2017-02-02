/**
 * Created by namik on 07.11.16.
 */
window.onload = function () {
    var myIndex = 0;
    carousel ();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("sliders");

        for (i = 0; i < x.length; i ++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {
            myIndex = 1;
        }

        x[myIndex - 1].style.display = "block";
        setTimeout(carousel, 2500);
    }

    var createPr = document.getElementById("createProject");
    var createMem = document.getElementById("createMember");
    var createEven = document.getElementById("createEvent");
    
    createMem.onclick = function () {
        // var
    }
}
