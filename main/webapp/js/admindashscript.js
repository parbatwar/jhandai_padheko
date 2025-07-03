console.log("JS loaded.");
function addRow() {
    const table = document.getElementById('dataBody');
    const newRow = document.createElement('tr');

    newRow.innerHTML = `
        <td>--</td>
        <td contenteditable="true">New Title</td>
        <td contenteditable="true">Draft</td>
        <td>
            <button class="edit-btn" onclick="editRow(this)">Edit</button>
            <button class="delete-btn" onclick="deleteRow(this)">Delete</button>
        </td>
    `;

    table.appendChild(newRow);
}

function deleteRow(btn) {
    const row = btn.closest('tr');
    row.remove();
}

function editRow(btn) {
    alert("Edit functionality is static. Just click and edit the text directly.");
}
