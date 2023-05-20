import React, { Component, useEffect, useState } from 'react';
import axios from 'axios';
import CommonLayout from '../layouts/CommonLayout';

const GoodsCard = ({ good }) => {
    return (
        <div>
            <div className="card w-96 bg-base-100 shadow-xl">
                <figure><img src="/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg" alt="Shoes" /></figure>
                <div className="card-body">
                    <h2 className="card-title">{good.name}</h2>
                    <p>商品介绍</p>
                    <div className="card-actions justify-end">
                        <button className="btn btn-primary">购买</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

const GoodsPage = () => {

    const [goods, setGoods] = useState();

    useEffect(() => {
        axios.get('http://localhost:8001/goods/getPageList?pageNum=1&pageSize=10&status=1').then((res) => {
            setGoods(res.data.data);
            console.log(res.data.data);
        }).catch((err) => {
            console.log(err);
        })
    }, [])

    return (
        <CommonLayout>
            <h1 className='text-3xl font-black'>商品</h1>
            <div className='flex space-x-7 '>
                {
                    goods && goods.records.map((good) => {
                        return (
                            <div key={good.id}>
                                <GoodsCard good={good} />
                            </div>
                        )
                    })
                }
            </div>
        </CommonLayout>

    )
}

export default GoodsPage;