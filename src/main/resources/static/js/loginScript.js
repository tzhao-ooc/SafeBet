let button; // "Login" signup entry

document.addEventListener('DOMContentLoaded', function() {

    function showErrMsg(ele) {
        let temp = ele;
        if(temp.nextElementSibling) return;
        ele.style.color = "red";
        ele.style.outlineColor = "red";
        temp.after(document.createElement("span"));
        temp.nextElementSibling.classList.add("errorMsg");
    }


    function ClearErrMsg(ele) {
        let temp = ele;
        if (!temp.nextElementSibling) return;
        ele.style.color = "black";
        ele.style.outlineColor = "lightgray";
        temp.nextElementSibling.remove();
    }

    document.getElementsByName("username")[0].addEventListener('change', checkUsername)
    document.getElementsByName("password")[0].addEventListener('change', checkPwd)

    function checkUsername (evt) {
        var obj = evt.target;
        if (obj.value.length < 5) {
           
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/>  Username must be at least 5 characters in length";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }

    function checkPwd (evt) {
        var obj = evt.target;
        if (obj.value.length < 4) {
            showErrMsg(obj);
            console.log(obj.value);
            console.log(obj.nextElementSibling);
            obj.nextElementSibling.innerHTML = "<br/>  Password must be at least 4 characters in length";
            return;
        } else {
            ClearErrMsg(obj);
            readySubmit();
        }
    }
    
    function readySubmit () {
        var error = 0;
        let inputElem = document.querySelectorAll('.usrInput');
        for ( let i of inputElem) {
            if (i.value == "") error++;
            if (i.nextElementSibling) error++;
        }
        if (error == 0) {
            document.getElementById("submitBTN").removeAttribute("disabled");
        }
    }
    

});

