
// 폼 전송 함수
function submitAddItemForm() {
    var addItemForm = document.getElementById("addItemForm");
    var refri_id = document.getElementById("refri_id").value; // refri_id 값을 읽어옴
    addItemForm.action = "/item/" + refri_id; // URL에 refri_id를 포함시킴
    addItemForm.submit(); // 폼을 전송하여 POST 요청 보냄
}

function openModal(itemId, refri_id) {
    var addItemModal = document.getElementById("addItemModal");
    addItemModal.style.display = "block";
    document.getElementById("refri_id").value = refri_id;
}

    function closeModal() {
    var addItemModal = document.getElementById("addItemModal");
    addItemModal.style.display = "none";
}


    //품목삭제
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
            xhr.open("DELETE", "/item/" + selectedItems[j], true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("삭제 성공");
                    window.location.reload();
                }
            };
            xhr.send();
        }
    }