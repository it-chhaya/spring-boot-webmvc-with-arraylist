let endPoint = "/api/articles";
let uiEndPoint = "/ui/articles";
let id;
let articleForUpdate;


$(document).ready(function () {

    getArticles();

    $('.btnSave').on('click', function () {

        let article = {
            title: $('.inputTitle').val(),
            details: $('.inputDetails').val()
        }

        addArticle(article)

    });

    $(document).on('click', '.btnDelete', function () {
        id = $(this).parent().siblings('.articleId').text();
    })

    $('.btnDeleteWithConfirm').on('click', function () {
        deleteArticle(id)
    })

    $(document).on('click', '.btnUpdate', function() {
        articleForUpdate = {
            id: $(this).parent().siblings('.articleId').text(),
            title: $(this).parent().siblings('.articleTitle').text(),
            details: $(this).parent().siblings('.articleDetails').text()
        }
        $('#articleTitle').val(articleForUpdate.title);
        $('#articleDetails').val(articleForUpdate.details);
    })

    $('.btnSaveUpdate').on('click', function() {
        articleForUpdate.title = $('#articleTitle').val();
        articleForUpdate.details = $('#articleDetails').val();
        updateArticle(articleForUpdate);
    })

});

function updateArticle(article) {
    $.ajax({
        url:endPoint,
        method:'PUT',
        headers:{
            'content-type':'application/json'
        },
        data:JSON.stringify(article),
        success:function() {
            $('#updateModal').modal('hide');
            getArticles();
        },
        error:function(error) {
            console.log(error)
        }
    })
}

function deleteArticle(id) {
    $.ajax({
        url: endPoint + '/' + id,
        method: 'DELETE',
        success: function (response) {
            //alert(response)
            $('.modal').modal('hide');
            getArticles();
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function addArticle(article) {
    $.ajax({
        url: endPoint,
        headers: {
            'content-type': 'application/json'
        },
        method: 'POST',
        data: JSON.stringify(article),
        success: function () {
            alert('You add an article successfully');
            window.location = uiEndPoint
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function getArticles() {

    $.ajax({
        url: endPoint,
        method: 'GET',
        success: function (response) {
            displayArticles(response);
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function displayArticles(data) {

    let result = '';

    for (let d of data) {
        result += '<tr>\n' +
            '                    <td class="articleId">' + d.id + '</td>\n' +
            '                    <td class="articleTitle">' + d.title + '</td>\n' +
            '                    <td class="articleDetails">' + d.details + '</td>\n' +
            '                    <td>\n' +
            '                        <button class="btn btn-danger btnDelete"\n' +
            '                                type="button"\n' +
            '                                data-toggle="modal"\n' +
            '                                data-target="#staticBackdrop">\n' +
            '                            <i class="fas fa-trash"></i>\n' +
            '                        </button>\n' +
            '                        <button class="btn btn-primary btnUpdate"\n' +
            '                                data-toggle="modal"\n' +
            '                                data-target="#updateModal">\n' +
            '                            <i class="fas fa-edit"></i>\n' +
            '                        </button>\n' +
            '                    </td>\n' +
            '                </tr>';
    }

    $('.tbody-one').html(result);

}