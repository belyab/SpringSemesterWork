document.getElementById('addOrder').addEventListener('click', async () => {
    const inputEmail = document.getElementById('clientEmail');
    const inputPhoneNumber = document.getElementById('clientPhoneNumber');
    const inputZodiacSign = document.getElementById('clientZodiacSign');

    const clientEmail = inputEmail.value;
    const clientPhoneNumber = inputPhoneNumber.value;
    const clientZodiacSign = inputZodiacSign.value;


        if (clientEmail, clientPhoneNumber, clientZodiacSign) {
            const res = await fetch('http://localhost:8080/orders/addOrder', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({clientEmail,clientPhoneNumber,clientZodiacSign, completed: false})
            });

            const orders = await res.json();
            taskToHTML(orders);

            inputEmail.value= '';
            inputPhoneNumber.value= '';
            inputZodiacSign.value= '';
        }
    }
)
async function getAllOrders() {
    const res = await fetch('http://localhost:8080/orders/getAllOrders');
    const orders = await res.json();

    console.log(orders);
    orders.forEach(orders => taskToHTML(orders))
}

window.addEventListener('DOMContentLoaded', getAllOrders);

function taskToHTML({id, email, phone, sign}) {
    const orderList = document.getElementById('orders');
    orderList.insertAdjacentHTML('beforeend',
        `    <div class="form-check" id="orders${id}">
    <table class="table">
            <thead>
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Email</th>
                <th scope="col">PhoneNumber</th>
                <th scope="col">ZodiacSign</th>
 
                </tr>
            </thead>
 
                <tr>
                    <td> ${id}}</td>
                    <td> ${email}}</td>
                    <td> ${phone}}</td>
                    <td> ${sign}}</td>

                </tr>
            </tbody>
        </table>

        <button onclick="deleteOrder(${id})" type="button" class="btn-close"
                aria-label="Close" style="font-size: 10px"></button>
    </div>`
    );
}

async function deleteOrder(id) {
    const res = await fetch(` http://localhost:8080/orders/deleteOrder/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    });

    const data = await res.json();
    console.log(data);

    if (data) {
        document.getElementById(`orders${id}`).remove();
    }
}
