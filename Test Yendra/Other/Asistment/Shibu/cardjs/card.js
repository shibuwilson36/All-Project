var items = [

    {
        name: 'lipstick',
        id: 1,
        price: 499
    },
    {
        name: 'eyeliner',
        id: 2,
        price: 999
    },
    {
        name: 'eyeliner',
        id: 2,
        price: 599
    },
    {
        name: 'watch',
        id: 3,
        price: 1000
    },
    {
        name: 'watch',
        id: 3,
        price: 5000
    },
    {
        name: 'trimmer',
        id: 4,
        price: 500
    }
];

var div1 = document.createElement("div");
div1.classList = "container mt-5"

function display(items) {
    for (let i = 0; i < items.length; i++) {

        let div2 = document.createElement("div");
        let h1 = document.createElement("h1");
        let br = document.createElement("br");
        let p = document.createElement("p");

        div2.classList = " card m-3 col-md-4 float-left card-body bg-primary"

        h1.textContent = "Name : " + items[i].name;
        p.textContent = "Price : " + items[i].price;
        div2.appendChild(h1);
        h1.appendChild(p);
        p.appendChild(br);
        div1.appendChild(div2)
        document.body.appendChild(div1);

    }
}
display(items)


function searchByName() {
    let eSearch = document.getElementById("search");
    let arrayItem = []
    for (var item of items) {
        if (item.name.startsWith(eSearch.value) && eSearch.value.length !== 0) {
            console.log(item.name);

            arrayItem.push(item)
            console.log(arrayItem);

        }

    }
    div1.innerHTML = "";
    display(arrayItem)
    sortPrice(arrayItem)


}





function sortPrice(items) {
    let select = document.getElementById("select")

    select.addEventListener("change", function() {


        let option = select.options[select.selectedIndex]

        if (option.value == 0) {

            let sorted = items.sort(function(item1, item2) {
                return item2.price - item1.price
            })
            div1.innerHTML = "";

            display(sorted)

        }
        if (option.value == 1) {
            let sorted = items.sort(function(item1, item2) {
                return item1.price - item2.price
            })
            div1.innerHTML = "";

            display(sorted)

        }

    })
}
sortPrice(items)