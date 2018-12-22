const clientID = "118785532196-avsm0e3idr3irvok4aflni1vnv2p3gf9.apps.googleusercontent.com";
const clientSeceret = "zeTSk7RflyhAlsdZD14aPy-2";

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId());
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail());
    console.log('id_token: ' + googleUser.getAuthResponse().id_token);

    //do not post all above info to the server because that is not secure.
    //just send the id_token

    var redirectUrl = 'login';

    //using jquery to post data dynamically
    var form = $('<form action="' + redirectUrl + '" method="post">' +
                     '<input type="text" name="id_token" value="' +
                      googleUser.getAuthResponse().id_token + '" />' +
                                                           '</form>');
    $('body').append(form);
    form.submit();
 }