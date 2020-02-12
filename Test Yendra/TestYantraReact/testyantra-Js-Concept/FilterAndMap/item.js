var items=[
    {
        id:1,
        name:"Lipstick",
        price:850

    },
    {
        id:2,
        name:"eyeliner",
        price:500

    },
    {
        id:3,
        name:"beard oil",
        price:900

    },
    {
        id:4,
        name:"Rakhi",
        price:250

    }
]

for (var item of items) {
    console.log(item);
    
}
// console.log(items[0]);
// console.log(items[1]);
// console.log(items[2]);
// console.log(items[3]);
console.log("--------------filter----------------------");

var itemGraterThan500=items.filter(val=>val.price>500);

for (var item of itemGraterThan500) {
    console.log(item);
    
}



var itemWithGst=items.map(val=>{
    
    var newval=Object.assign({}, val);
    // newval.name=val.name;
    // newval.price=val.price

    newval.price=val.price+50

    return newval
}
    
    )

for (var item of itemWithGst) {
    console.log(item);
    
}

console.log("---------------Oranginal---------------------");

for (var item of items) {
    console.log(item);
    
}