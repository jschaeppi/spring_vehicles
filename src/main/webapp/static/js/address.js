function buildTable(id='') {
    $.getJSON('/api/contacts/' + id , {ajax: true}, (contact => {
            var fullName = contact.firstName + ' ' + contact.lastName;
            $.each(contact.contactAddress, ((j, address) => {
            $('#address-table').find('tbody')
                .append('<tr>' +
                    '<td>' + address.id + '</td>' +
                    '<td><a href="/contact/' + contact.id + '">' + fullName + '</a></td>' +
                    '<td>' + address.street + '</td>' +
                    '<td>' + address.street2 + '</td>' +
                    '<td>' + address.city + '</td>' +
                    '<td>' + address.state + '</td>' +
                    '<td>' + address.zip + '</td>' +
                    '<td>' + address.addressType + '</td>' +
                    '<td>' + '<button class="btn btn-primary" onclick="editAddress(' + address.id +
                    ')">Edit</button>' +
                    '</td>' +
                    '<td>' +
                    '<button class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal"' +
                    ' data-record-id="' + address.id + '">Delete</button>' +
                    '</td>')
            }))
        }));
}

function insertAddress() {
    const id = $('#contactId').val();
    $.getJSON('/api/contacts/' + id, {ajax: true},
        (contact) => {
            const contactId = $('#contactId').val(contact.id)
            const contactVersion = $('#contactVersion').val(contact.version)
            const firstName = $('#firstName').val(contact.firstName)
            const lastName = $('#lastName').val(contact.lastName)
            $('#addressId').val("");
            $('#addressVersion').val("");
            $('#addressType').val("");
            $('#street').val("");
            $('#street2').val("");
            $('#city').val("");
            $('#state').val("");
            $('#zip').val("");
            $('#contactModal').modal('show');
        })
}

function saveAddress() {
    const contactId = $('#contactId').val();
    const contactVersion = $('#contactVersion').val();
    const firstName = $('#firstName').val();
    const lastName = $('#lastName').val();
    const addressId = $('#addressId').val();
    const addressVersion = $('#addressVersion').val();
    const addressType = $('#addressTypes option:selected').val()
    const street = $('#street').val();
    const street2 = $('#street2').val();
    const city = $('#city').val();
    const state = $('#state').val();
    const zip = $('#zip').val();

    const contact = {
        id: contactId,
        version: contactVersion,
        firstName: firstName,
        lastName: lastName,
        contactAddress: [{
            id: addressId,
            version: addressVersion,
            addressType: addressType,
            street: street,
            street2: street2,
            city: city,
            state: state,
            zip: zip
        }]
    }

    $.ajax({
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        url: "/api/contacts/",
        data: JSON.stringify(contact),
        dataType: "json",
        success: () => {
            window.location.reload();
        }


    })
}

function editAddress(id) {
    const selectedOption = $('#addressTypes option:selected').val();
    $('#' + selectedOption).removeAttr('selected');
    $.getJSON('/api/address/' + id, {ajax: true},
        (address) => {
            const addressId = $('#addressId').val(address.id)
            const addressVersion = $('#addressVersion').val(address.version)
            const addressType = $('#addressTypes option[value=' + address.addressType + ']').attr('selected', 'selected');
            const street = $('#street').val(address.street);
            const street2 = $('#street2').val(address.street2);
            const city = $('#city').val(address.city);
            const state = $('#state').val(address.state);
            const zip = $('#zip').val(address.zip);
        })
    $('#contactModal').modal('show');
}

function deleteModal() {
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        let $modalDiv = $(e.delegateTarget);
        let id = $(this).data('recordId');
        $.ajax({
            type: "DELETE",
            url: "/api/address/" + id,
            async: true,
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Address");
            }
        })
    });
    $('#confirmDeleteModal').on('show.bs.modal', function(e) {
        let data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    })
}