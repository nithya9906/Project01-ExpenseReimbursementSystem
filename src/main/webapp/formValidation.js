function doValidate()
{
    if (document.register.email.value =="")
    {
        alert("Please put your name");
        document.register.email.value.focus();
        return false;
    }
    var readmail = document.register.email;
    var checkatsymbol = readmail.indexof("@");
    var checkdotsymbol = readmail.lastindexof(".");
    if (readmail.value =="" || checkatsymbol<1)
    {
        alert("Please put the correct email address");
        document.register.email.focus();
        return false;
}
}