import React, { Component, useEffect, useState } from "react";
import axios from "axios";
import CommonLayout from "../layouts/CommonLayout";
import { Link } from "react-router-dom";

const goods = [
  {
    id: 1,
    name: "Product 1",
    price: 19.99,
    category: "Electronics",   
    image: "https://via.placeholder.com/300.png?text=Product1",
  },
  {
    id: 2,
    name: "Product 2",
    price: 9.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product2",
  },
  {
    id: 3,
    name: "Product 3",
    price: 49.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product3",
  },
  {
    id: 4,
    name: "Product 4",
    price: 29.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product4",
  },
  {
    id: 5,
    name: "Product 5",
    price: 14.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product5",
  },
  {
    id: 6,
    name: "Product 6",
    price: 39.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product6",
  },
  {
    id: 7,
    name: "Product 7",
    price: 24.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product7",
  },
  {
    id: 8,
    name: "Product 8",
    price: 12.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product8",
  },
  {
    id: 9,
    name: "Product 9",
    price: 59.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product9",
  },
  {
    id: 10,
    name: "Product 10",
    price: 34.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product10",
  },
  {
    id: 11,
    name: "Product 11",
    price: 18.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product11",
  },
  {
    id: 12,
    name: "Product 12",
    price: 49.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product12",
  },
  {
    id: 13,
    name: "Product 13",
    price: 29.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product13",
  },
  {
    id: 14,
    name: "Product 14",
    price: 16.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product14",
  },
  {
    id: 15,
    name: "Product 15",
    price: 44.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product15",
  },
  {
    id: 16,
    name: "Product 16",
    price: 21.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product16",
  },
  {
    id: 17,
    name: "Product 17",
    price: 11.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product17",
  },
  {
    id: 18,
    name: "Product 18",
    price: 54.99,
    category: "Home",
    image: "https://via.placeholder.com/300.png?text=Product18",
  },
  {
    id: 19,
    name: "Product 19",
    price: 31.99,
    category: "Electronics",
    image: "https://via.placeholder.com/300.png?text=Product19",
  },
  {
    id: 20,
    name: "Product 20",
    price: 13.99,
    category: "Clothing",
    image: "https://via.placeholder.com/300.png?text=Product20",
  },
];

const GoodsCard = ({ good }) => {
  return (
    <div>
      <div className="card w-96 bg-base-100 shadow-xl">
        <figure>
          <img src={good.image} alt="Shoes" className="w-full" />
        </figure>
        <div className="card-body">
          <h2 className="card-title">{good.name}</h2>
          <p>${good.price}</p>
          <div className="card-actions justify-end">
            <button className="btn btn-primary">
              <Link to={"/gooddetail"}>购买</Link>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

const GoodsPage = () => {
  useEffect(() => {
    // axios
    //   .get(
    //     "http://localhost:8001/goods/getPageList?pageNum=1&pageSize=10&status=1"
    //   )
    //   .then((res) => {
    //     setGoods(res.data.data);
    //     console.log(res.data.data);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });

    console.log(goods);
  }, []);

  return (
    <CommonLayout>
      <h1 className="text-3xl font-black">商品</h1>
      <div className="flex flex-wrap">
        {goods &&
          goods.map((good) => {
            return (
              <div key={good.id} className="m-[1rem]">
                <GoodsCard good={good} />
              </div>
            );
          })}
      </div>
    </CommonLayout>
  );
};

export default GoodsPage;
