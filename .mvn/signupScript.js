
let button; // "Create" signup entry
let signupInfo = []; //stores email, user, passwords
let signupStatus = false; // if false, do not send to backend.
let email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // used to validate email


document.addEventListener('DOMContentLoaded', function() {
    
    button = document.querySelector('input[class="btn"]');
    button.addEventListener('click', function(evt){

        evt.preventDefault()
        
        signupInfo = [];

        signupInfo.push(document.getElementById('email').value)
        signupInfo.push(document.getElementById('username').value)
        signupInfo.push(document.getElementById('password').value)
        signupInfo.push(document.getElementById('confirmP').value)
        
        if(email.test(signupInfo[0]) == false)
        {
            alert("invalid email address.");
            document.getElementById('email').value = '';

            //FUTURE: I want "email" to turn red when users make this mistake.
        }
        else if((signupInfo[1]).length < 5)
        {
            alert("Username must be at least 5 characters in length");
            document.getElementById('username').value = "";

            //FUTURE: I want username to turn red if wrong.
        }
        else if(signupInfo[2] != signupInfo[3])
        {
            alert("Passwords do not match, they must be identical");
            document.getElementById('password').value = '';
            document.getElementById('confirmP').value = '';
            
            // FUTURE: I want to make it so that "Create a Passowrd" and
            // "Confirm Password" turn red when a user makes this mistake

            // FUTURE: make it so passwords have at least 1 number and captial
        }
        else
        {
            //signupstatus must be true or else DO NOT send to backend.
            signupStatus = true;
        }

        // inspect element on the webpage, and go to console to see what is returned
        console.log(signupInfo)
        console.log(signupStatus)

});

   
});
