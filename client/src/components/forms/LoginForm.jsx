import { useState } from "react";
import { LockClosedIcon } from "@heroicons/react/solid";
import nav_logo from '../../assets/logo.png'

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = (e) => {
        e.preventDefault();
        // Do something with the username and password
        console.log(`Logged in with username: ${username} and password: ${password}`);
    };

    return (
        <div className="flex h-screen bg-gray-200">
            <div className="m-auto w-96 bg-white rounded-lg shadow-lg p-6">
                <div className="text-center">
                    <img
                        className="h-20 mx-auto"
                        src={nav_logo}
                        alt="logo"
                    />
                    <h1 className="text-2xl font-black mt-2 ">登录Hibox</h1>
                </div>
                <form className="mt-6" onSubmit={handleLogin}>
                    <div>
                        <label className="block text-gray-600 font-semibold">用户名</label>
                        <input
                            type="text"
                            placeholder="Enter your username"
                            className="w-full px-4 py-2 mt-2 border rounded-lg text-gray-700 focus:outline-none focus:border-blue-500"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </div>
                    <div className="mt-4">
                        <label className="block text-gray-600 font-semibold">密码</label>
                        <input
                            type="password"
                            placeholder="Enter your password"
                            className="w-full px-4 py-2 mt-2 border rounded-lg text-gray-700 focus:outline-none focus:border-blue-500"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </div>
                    <div className="mt-6">
                        <button
                            type="submit"
                            className="w-full px-4 py-2 tracking-wide text-white bg-blue-500 rounded-lg hover:bg-blue-400 transition-colors"
                        >
                            登录
                        </button>
                    </div>
                </form>
                <div className="mt-4 text-center">
                    <a href="#" className="text-blue-500 hover:text-blue-700 font-semibold">
                        忘记密码？
                    </a>
                </div>
                <div className="mt-4 flex justify-center">
                    <hr className="w-1/3" />
                    <p className="mx-2 text-gray-500 font-semibold">或</p>
                    <hr className="w-1/3" />
                </div>
                <div className="mt-4 flex justify-center items-center">
                    <button className="bg-blue-500 hover:bg-blue-400 text-white rounded-full p-2 mr-2 transition-colors">
                        <i className="fab fa-facebook-f"></i>
                    </button>
                    <button className="bg-gray-200 hover:bg-gray-300 text-gray-700 rounded-full p-2 transition-colors">
                        <i className="fab fa-google"></i>
                    </button>
                </div>
                <div className="mt-4 text-center">
                    <p className="text-gray-500">
                       没有账户?{" "}
                        <a href="#"
                            className="text-blue-500 hover:text-blue-700 font-semibold"
                        >
                            注册
                        </a>
                    </p>
                </div>
            </div>
        </div>
    );
}

export default Login;

