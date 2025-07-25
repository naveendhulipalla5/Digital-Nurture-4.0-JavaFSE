import React from "react";
import Cart from "./Cart";
import "./OnlineShopping.css"; // ✅ Import CSS here

class OnlineShopping extends React.Component {
  render() {
    const items = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "TV", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 },
    ];

    return (
      <div className="shopping-container">
        <h2 className="shopping-title">Items Ordered :</h2>
        <table className="shopping-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <Cart key={index} itemname={item.itemname} price={item.price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
