import React, { Component, useEffect, useState } from "react";
import axios from "axios";
import CommonLayout from "../layouts/CommonLayout";
import { Link } from "react-router-dom";
import nutrition_powder from "../../assets/nutrition_powder.jpg";
import nutr_powder from "../../assets/nutr_powder.jpg";
import nutrition_pills from "../../assets/nutrition_pills.jpg";

const goods = [
  {
    id: 1,
    name: "高熵营养粉",
    price: 39.99,
    category: "Electronics",   
    image: nutr_powder,
  },
  {
    id: 2,
    name: "高熵营养粉-大罐装",
    price: 49.99,
    category: "Clothing",
    image: nutrition_powder,
  },
  {
    id: 3,
    name: "高熵营养丸",
    price: 29.99,
    category: "Home",
    image: nutrition_pills,
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
