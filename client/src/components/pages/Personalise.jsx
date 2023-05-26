import React from "react";
import CommonLayout from "../layouts/CommonLayout";

const CommonInput = ({ name, value }) => {
  return (
    <div>
      <label htmlFor="" className="">
        {name}
      </label>
      <br />
      <input
        type="text"
        placeholder={value}
        className="my-3 input-sm input input-bordered input-success w-full max-w-xs"
      />
    </div>
  );
};

const Personalise = () => {
  return (
    <CommonLayout>
      <div className="">
    
      <iframe src='https://www.wjx.cn/vm/YmBddzu.aspx?width=750&source=iframe&s=t' className="overflow-auto w-full h-screen" title="wenjian"></iframe>
      </div>
    </CommonLayout>
  );
};

export default Personalise;
