import React from "react";
import CommonLayout from "../layouts/CommonLayout";
import { Link } from "react-router-dom";
const Envir = () => {
  return (
    <CommonLayout>
      <div className="">
        <span className="text-4xl font-black bg-clip-text text-transparent bg-gradient-to-r from-green-400 to-blue-500">生态系统</span>
        <div className="w-full flex flex-col justify-around">
          <div className="px-[5rem] py-[3rem]  flex justify-between">
            <Link to="https://github.com/cherrieszzz/hi-box">
              <svg aria-hidden="true" className="w-30 h-30">
                {" "}
                <use xlinkHref="#icon-github-fill"></use>{" "}
              </svg>
            </Link>{" "}
            <div className="w-3/4">
              <h2 className="font-black text-3xl">Github</h2>
            <p className="my-5 font-light">在hibox开源社区贡献你的代码</p>
            </div>
          
          </div>

          <div className="px-[5rem] py-[3rem] flex justify-between">
            <Link to="https://www.douyin.com/user/MS4wLjABAAAAYwDptOsZA2dit3yphA_HmaAXMSFgtZmn5-5ectIIuy6mGGRktPqvv4mEgRb6ODHh">
              <svg aria-hidden="true" className="w-30 h-30">
                {" "}
                <use xlinkHref="#icon-tiktok"></use>{" "}
              </svg>
            </Link>{" "}
            <div className="w-3/4">
              <h2 className="font-black text-3xl">抖音</h2>
            <p className="my-5 font-light">高熵营养粉，由河南工业大学材料学院陈金身教授用近十年时间精心研发的一款全营养食品。营养粉有90多种食材加工合成，富含大量的维生素、膳食纤维及微量元素硒。根据人体八大系统所需营养素，考虑中国人的饮食结构，产品在加工过程中保证了营养成分不流失。产品可作为代餐食品，广受好评。我们团队在陈教授指导下，积极参与高熵营养粉的研发。在产品配方调整与实验过程中，团队得到了锻炼，体现了团队协作意识和精益求精的工匠精神。</p>
            </div>
          </div>

          <div className="px-[5rem] py-[3rem] flex justify-between">
            <Link to="https://www.xiaohongshu.com/user/profile/5c561b89000000001802e3e7">
              <svg aria-hidden="true" className="w-30 h-30">
                {" "}
                <use xlinkHref="#icon-jiaqiangban"></use>{" "}
              </svg>
            </Link>{" "}
            <div className="w-3/4">
              <h2 className="font-black text-3xl">小红书</h2>
            <p className="my-5 font-light">大学生创新创业，我们一直在行动！ 高熵营养粉，你的营养加油站！食全食美，健康生活！ 一款采用40余种五谷杂粮、20余种果蔬野菜、20余种干果、5种海产品等合理搭配融合而成的营养粉！</p>
            </div>
          </div>
        </div>
      </div>
    </CommonLayout>
  );
};

export default Envir;
