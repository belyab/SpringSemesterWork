document.getElementById('addOrder').addEventListener('click', async () => {
    const inputEmail = document.getElementById('client_email');
    const inputPhoneNumber = document.getElementById('client_phone_number');
    const inputZodiacSign = document.getElementById('client_zodiac_sign');

    const client_email = inputEmail.value;
    const client_phone_number = inputPhoneNumber.value;
    const client_zodiac_sign = inputZodiacSign.value;


        if (client_email, client_phone_number, client_zodiac_sign) {
            const res = await fetch('http://localhost:8080/orders/addOrder', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({client_email,client_phone_number,client_zodiac_sign, completed: false})
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

function taskToHTML({id, client_email, client_phone_number, client_zodiac_sign}) {
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
                    <td> ${client_email}}</td>
                    <td> ${client_phone_number}}</td>
                    <td> ${client_zodiac_sign}}</td>

                </tr>
            </tbody>
            <button onclick="deleteOrder(${id})" type="button" class="btn-close"
                aria-label="Close" style="font-size: 10px"></button>
        </table>

        
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
