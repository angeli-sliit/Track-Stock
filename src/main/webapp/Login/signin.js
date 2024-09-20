function validInput() {
    var username = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var alertmsg = document.getElementById("alertmsg");

    if (username.trim() === '' || password.trim() === '') {
        alertmsg.style.display = 'block';
        alertmsg.innerHTML = 'Both fields are required';
        return false;
    } else {
        alertmsg.style.display = 'none';
        return true;
    }
}


document.getElementById('login-btn').addEventListener('click', function(event) {
    var button = document.getElementById('login-btn');
    var loginText = document.getElementById('login-text');

    loginText.textContent = 'Signing in';

    setTimeout(function() {
        loginText.textContent = 'Sign In';
        button.classList.remove('loading');
        if (validInput()) {
            console.log("submitted");
            var form = document.getElementById("loginform");
            form.submit();
        }
    }, 2000);

    event.preventDefault(); // Prevent default form submission behavior
});
