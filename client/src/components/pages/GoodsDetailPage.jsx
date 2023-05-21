import React from "react";

export default function GoodsDetailPage() {
  return (
    <div>
      <div className="flex justify-center items-center min-h-screen bg-gray-100">
        <div className="max-w-3xl bg-white rounded-lg shadow-lg p-8">
          <div className="flex justify-between">
            <div className="w-1/2">
              <img src="" alt="Product" className="w-full" />
            </div>
            <div className="w-1/2 pl-8">
              <h2 className="text-2xl font-bold mb-4">Example Product</h2>
              <p className="text-gray-600 mb-4">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
                eget finibus nisl, ac dapibus massa. Mauris nec rutrum urna,
                quis cursus felis.
              </p>
              <div className="mb-4">
                <span className="text-gray-600">Price: </span>
                <span className="text-blue-600 font-bold">$99.99</span>
              </div>
              <div className="mb-4">
                <span className="text-gray-600">Category: </span>
                <span className="text-blue-600 font-bold">Electronics</span>
              </div>
              <button className="bg-blue-600 text-white rounded-lg px-4 py-2 hover:bg-blue-700">
                Add to Cart
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
