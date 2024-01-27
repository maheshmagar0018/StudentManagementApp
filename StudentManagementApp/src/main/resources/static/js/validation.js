// validation.js
function isValidDate(dateString) {
    var regex = /^\d{4}-\d{2}-\d{2}$/;
    return dateString.match(regex);
}

function isValidEmail(email) {
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return email.match(regex);
}