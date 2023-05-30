import React from "react";
import CommonLayout from "../layouts/CommonLayout";

const About = () => {
  return (
    <CommonLayout>
      <div className=" py-12 px-4 sm:px-6 lg:px-8">
        <div className="max-w-7xl mx-auto">
          <h1 className="text-3xl leading-9 font-extrabold text-gray-900 sm:text-4xl sm:leading-10 mb-8">
            关于我们
          </h1>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                社区交流
              </h2>
              <p className="text-gray-700">
                欢迎加入我们的社群！无论你是想找到新的灵感，还是想结交更多的朋友，我们都为你提供了一个舒适的环境。快来加入我们，开启一段全新的旅程吧！
              </p>
            </div>
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                私人定制
              </h2>
              <p className="text-gray-700">
                我们提供专业的私人订制服务，满足你的个性化需求。我们的团队将会与你紧密合作，确保你得到最满意的结果。快来尝试吧！
              </p>
            </div>
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                科普专栏
              </h2>
              <p className="text-gray-700">
                科普，从现在开始。我们的专栏涵盖了各种各样的科学知识，从生态环保到新技术，从基础知识到前沿研究。
              </p>
            </div>
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                全球合作
              </h2>
              <p className="text-gray-700">
                我们与全球各地的合作伙伴紧密合作，共同推动科学与技术的发展。通过跨国合作项目，我们为全球创新和进步贡献力量。
              </p>
            </div>
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                知识分享
              </h2>
              <p className="text-gray-700">
                在我们的平台上，你可以分享你的知识和经验，与他人交流，共同成长。通过分享，我们可以一起探索新的领域和解决现实问题。
              </p>
            </div>
            <div className="bg-white shadow-lg rounded-lg p-6">
              <h2 className="text-xl leading-6 font-semibold text-gray-900 mb-4">
                创新实验室
              </h2>
              <p className="text-gray-700">
                我们拥有现代化的创新实验室，致力于开展前沿科学研究和技术创新。在这里，你可以参与激动人心的实验和项目，探索未知的领域。
              </p>
            </div>
          </div>
        </div>
      </div>
    </CommonLayout>
  );
};

export default About;
