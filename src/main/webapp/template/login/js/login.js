function toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})


const $$$ = (id) => {
    return document.getElementById(id);
};

$$$('input-username').addEventListener('blur', () => {
    let email = $$$('input-username').value;
    email = email.slice(0, -10);
    fetch('http://localhost:8080/api/home/check/' + email || ' ')
        .then(response => response.json())
        .then(response => {
            if (response === false) {
                $$$('emailError').innerHTML = "Email không tồn tại!";
            }
        })
});

$$$('input-username').addEventListener('focus', () => {
    $$$('emailError').innerHTML = "";
})

$$$('su-email-input').addEventListener('blur', () => {
    let email = $$$('su-email-input').value;
    email = email.slice(0, -10);
    fetch('http://localhost:8080/api/home/check/' + email || ' ')
        .then(response => response.json())
        .then(response => {
            if (response === true) {
                $$$('su-emailError').innerHTML = "Email đã tồn tại!";
                $$$('btn-su').disabled = true;
            }
        })
});

$$$('su-email-input').addEventListener('focus', () => {
    $$$('su-emailError').innerHTML = "";
    $$$('btn-su').disabled = false;
})

$$$('input-password').addEventListener('focus', () => {
    $$$('passwordError').innerHTML = "";

})

const url_string = window.location.href;
const url = new URL(url_string);
const error = url.searchParams.get("error");
if (error != null) {
    $$$('passwordError').innerHTML = "Mật khẩu không đúng";
} else {
    $$$('passwordError').innerHTML = "";
}

