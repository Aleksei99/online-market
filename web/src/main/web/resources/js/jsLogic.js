function successfullyAdded() {
    let messageName = $('#category-form-name').val();
    let requestObject = {
        name: messageName
    };
    $.ajax('/admin/add',{
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(requestObject)
        }).done(function (category) {
            $('#category-name').text(category.name);
    })
}