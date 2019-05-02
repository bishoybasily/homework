$(document).ready(function () {

    $.get("/user/list.php", function (data) {
        $.each(data, function (index, user) {

            $(".container").append("<div class='row'>\n" +
                "                    <div class='col-sm-3'>\n" +
                "                        <p>" + user.name + "</p>\n" +
                "                    </div>\n" +
                "                    <div class='col-sm-4'>\n" +
                "                        <p>" + user.email + "</p>\n" +
                "                    </div>\n" +
                "                    <div class='col-sm-3'>\n" +
                "                        <p>" + user.telephone + "</p>\n" +
                "                    </div>\n" +
                "                    <div class='col-sm-2'>\n" +
                "                        <form method='post' action='user/delete.php'>\n" +
                "                            <input type='hidden' name='id' value=" + user.id + ">\n" +
                "                            <input class='btn btn-danger btn-block' type='submit' value='Delete'>\n" +
                "                        </form>\n" +
                "                    </div>\n" +
                "                </div>");

        });
    });

});
