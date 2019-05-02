$(document).ready(function () {

    var toggleEdit = false;

    $("#buttonToggleEdit").click(function () {
        if (toggleEdit) {
            $("div.row.update-on").css("display", "none");
            $("div.row.update-off").css("display", "block");
            toggleEdit = false;
            $("#buttonToggleEdit").text("Enable edit");
        } else {
            $("div.row.update-on").css("display", "block");
            $("div.row.update-off").css("display", "none");
            toggleEdit = true;
            $("#buttonToggleEdit").text("Disable edit");
        }
    });

    $.get("/user/list.php", function (data) {
        $.each(data, function (index, user) {

            $(".container")

                .append("<div class='row update-off'>\n" +
                    "    <div class='col-sm-3'>\n" +
                    "        <p>" + user.name + "</p>\n" +
                    "    </div>\n" +
                    "    <div class='col-sm-4'>\n" +
                    "        <p>" + user.email + "</p>\n" +
                    "    </div>\n" +
                    "    <div class='col-sm-3'>\n" +
                    "        <p>" + user.telephone + "</p>\n" +
                    "    </div>\n" +
                    "    <div class='col-sm-2'>\n" +
                    "        <form method='post' action='user/delete.php'>\n" +
                    "            <input type='hidden' name='id' value=" + user.id + ">\n" +
                    "            <input class='btn btn-danger btn-block' type='submit' value='Delete'>\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "</div>")

                .append("<div class=\"row update-on\">\n" +
                    "   <form action=\"user/update.php\" method=\"post\">\n" +
                    "       <input type='hidden' name='id' value=" + user.id + ">\n" +
                    "       <div class=\"col-sm-3\">\n" +
                    "           <div class=\"input-group\">\n" +
                    "               <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n" +
                    "               <input type=\"text\" class=\"form-control\" name=\"name\" value='" + user.name + "' placeholder=\"Name\">\n" +
                    "           </div>\n" +
                    "       </div>\n" +
                    "       <div class=\"col-sm-4\">\n" +
                    "           <div class=\"input-group\">\n" +
                    "               <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-envelope\"></i></span>\n" +
                    "               <input type=\"email\" class=\"form-control\" name=\"email\" value='" + user.email + "' placeholder=\"Email\">\n" +
                    "           </div>\n" +
                    "       </div>\n" +
                    "       <div class=\"col-sm-3\">\n" +
                    "           <div class=\"input-group\">\n" +
                    "               <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-headphones\"></i></span>\n" +
                    "               <input type=\"tel\" class=\"form-control\" name=\"telephone\" value='" + user.telephone + "' placeholder=\"Telephone\">\n" +
                    "           </div>\n" +
                    "       </div>\n" +
                    "       <div class=\"col-sm-2\">\n" +
                    "           <input class='btn btn-warning btn-block' type='submit' value='Update'>\n" +
                    "       </div>\n" +
                    "   </form>" +
                    "</div>");

        });
    });

});
