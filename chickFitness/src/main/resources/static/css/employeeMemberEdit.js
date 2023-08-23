$(document).ready(function () {
    // 初始化表單數據
    var form = {
        id: -1,
        firstName: "",
        lastName: "",
        email: ""
    };
//
    // 加載數據
    refreshPageData();

    // 處理表單提交
    $("form").submit(function (event) {
        event.preventDefault(); // 防止表單的默認提交行為

        var method = "";
        var url = "";

        if (form.id === -1) {
            method = "POST"; // 如果 id 為 -1，則表示新增員工，使用 POST 方法
            url = 'http://localhost:8080/emp';
        } else {
            method = "PUT"; // 否則，表示編輯員工，使用 PUT 方法
            url = 'http://localhost:8080/emp/' + form.id;
        }

        $.ajax({
            type: method,
            url: url,
            data: JSON.stringify(form),
            contentType: 'application/json',
            success: function () {
                successCallback(); // 成功時呼叫成功回調函數
            },
            error: function (response) {
                errorCallback(response); // 失敗時呼叫錯誤回調函數
            }
        });
    });

    // 處理刪除員工
    $(document).on("click", ".btn-danger", function () {
        var employeeId = $(this).data("id"); // 獲取點擊按鈕的 data-id 屬性值，即員工的 id

        $.ajax({
            type: "DELETE",
            url: 'http://localhost:8080/emp/' + employeeId,
            success: function () {
                successCallback(); // 成功時呼叫成功回調函數
            },
            error: function (response) {
                errorCallback(response); // 失敗時呼叫錯誤回調函數
            }
        });
    });

    // 處理編輯員工
    $(document).on("click", ".btn-info", function () {
        var employeeId = $(this).data("id"); // 獲取點擊按鈕的 data-id 屬性值，即員工的 id
        var employee = getEmployeeById(employeeId); // 根據 id 獲取員工數據

        form.firstName = employee.firstName;
        form.lastName = employee.lastName;
        form.email = employee.email;
        form.id = employee.id;
    });

    /* 私有方法 */
    // 透過 AJAX 從伺服器獲取員工數據
    function refreshPageData() {
        $.ajax({
            type: "GET",
            url: 'http://localhost:8080/emp/',
            success: function (response) {
                // 清空表格內容
                $(".table-hover tbody").empty();
                // 遍歷伺服器返回的數據，並將其添加到表格中
                $.each(response, function (index, employee) {
                    var row = "<tr>" +
                              "<td>" + employee.firstName + "</td>" +
                              "<td>" + employee.lastName + "</td>" +
                              "<td>" + employee.email + "</td>" +
                              "<td>" +
                              "<a class='btn btn-info' data-id='" + employee.id + "'>Edit</a>" +
                              "<a class='btn btn-danger' data-id='" + employee.id + "'>Remove</a>" +
                              "</td>" +
                              "</tr>";
                    $(".table-hover tbody").append(row);
                });
            },
            error: function (response) {
                console.log(response.statusText);
            }
        });
    }

    // 成功回調函數，刷新頁面數據並清空表單
    function successCallback() {
        refreshPageData();
        clearForm();
    }

    // 錯誤回調函數，輸出錯誤信息到控制台
    function errorCallback(response) {
        console.log(response.statusText);
    }

    // 清空表單數據
    function clearForm() {
        form.firstName = "";
        form.lastName = "";
        form.email = "";
        form.id = -1;
    }

    // 根據 id 從員工數組中獲取員工數據
    function getEmployeeById(id) {
        // 在這裡實現從數組中獲取員工數據的邏輯
    }
});
