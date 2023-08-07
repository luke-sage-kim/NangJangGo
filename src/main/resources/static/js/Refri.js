
function openRefriModal() {
    var addRefriModal = document.getElementById("addRefriModal");
    addRefriModal.style.display = "block";
}

function closeRefriModal() {
    var addRefriModal = document.getElementById("addRefriModal");
    addRefriModal.style.display = "none";
}

//냉장고삭제
function deleteSelectedItems() {
    var checkboxes = document.getElementsByName("checkbox1");
    var selectedItems = [];

    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            selectedItems.push(checkboxes[i].value);
        }
    }

    // 선택된 항목 ID를 AJAX를 통해 컨트롤러로 전송합니다.
    var xhr = new XMLHttpRequest();
    for (var j = 0; j < selectedItems.length; j++) {
        xhr.open("DELETE", "/refri/" + selectedItems[j], true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                alert("삭제 성공");
                window.location.reload();
            }
        };
        xhr.send();
    }
}