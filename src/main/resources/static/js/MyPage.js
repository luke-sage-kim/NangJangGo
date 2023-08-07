function openUpdateMemberModal() {
    var updateModal = document.getElementById("updateModal");
    updateModal.style.display = "block";
}

function closeUpdateMemberModal() {
    var updateModal = document.getElementById("updateModal");
    updateModal.style.display = "none";
}



function confirmDelete() {
    // Display a confirmation dialog
    var confirmMessage = "정말로 삭제하시겠습니까?";
    var confirmed = confirm(confirmMessage);

    if (confirmed) {
        // Submit the form using POST method
        document.getElementById('deleteForm').submit();
    }

    return false;
}