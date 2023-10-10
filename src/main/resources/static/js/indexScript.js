let button; // "Login" signup entry
let signinInfo = [];

document.addEventListener('DOMContentLoaded', function() {

    button = document.querySelector('input[value="Login"]');
    button.addEventListener('click', function(evt){

        evt.preventDefault();
        signinInfo = [] //so the array never goes above length = 2

        signinInfo.push(document.getElementById('username').value);
        signinInfo.push(document.getElementById('password').value);


        //FUTURE: here we will receieve whether the login info exists/is correct
        // and then alert the user accordingly.
        
        console.log(signinInfo) // see the info entry real-time in console view
    })

   

});

