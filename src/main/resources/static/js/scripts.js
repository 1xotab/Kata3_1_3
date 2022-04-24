// Empty JS for your own code to be here
$('document').ready(function() {

    $('.table #editButton').on('click',function(event) {

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href,function(user,status){
            $('#userId').val(user.id);
            $('#userFirstName').val(user.first_name);
            $('#userLastName').val(user.last_name);
            $('#userAge').val(user.age);
            $('#userEmail').val(user.email);
            $('#userPassword').val(user.password);
        });

        $('#editModal').modal();
    })
});

$('document').ready(function() {

$('.table #deleteButton').on('click',function(event) {

    event.preventDefault();

    var href = $(this).attr('href');

    $.get(href,function(user,status){
        $('#userIdDelete').val(user.id);
        $('#userFirstNameDelete').val(user.first_name);
        $('#userLastNameDelete').val(user.last_name);
        $('#userAgeDelete').val(user.age);
        $('#userEmailDelete').val(user.email);
    });

    $('#deleteModal').modal();
})

});