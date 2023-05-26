import CommonLayout from "../layouts/CommonLayout"

const user = {
    avatarUrl: 'https://i.328888.xyz/2023/05/17/VVDYr8.jpeg',
    username: 'Gatsby',
    email: 'greenteacore@outlook.com',
    phone: '123456',
    password: '*******'
}

const UserPage = () => {

    return (
        <CommonLayout>
            <div className="min-h-[50rem]">
                <div className="flex justify-around max-w-[70rem] mx-auto">
                    <div className="w-1/4 flex flex-col items-center">
                        <div className="avatar">
                            <div className="w-[5rem] h-[5rem] rounded-full ring ring-primary ring-offset-base-100 ring-offset-2">
                                <img src={user.avatarUrl} />
                            </div>

                        </div>
                        <div>
                            {user.username}
                        </div>
                    </div>


                    <div className="w-3/4">
                        个人信息
                        <div className="divider"></div>
                        <div>
                            <div>
                                <label htmlFor="">用户名</label>
                                <input type="text" placeholder="Type here" className="input input-bordered input-sm w-full max-w-xs" />
                            </div>

                            <div>
                                <label htmlFor="">电子邮箱</label>
                                <input type="text" placeholder="Type here" className="input input-bordered input-sm w-full max-w-xs" />
                            </div>

                            <div>
                                <label htmlFor="">修改密码</label>
                                <input type="text" placeholder="Type here" className="input input-bordered input-sm w-full max-w-xs" />
                                <label htmlFor="my-modal" className="btn btn-secondary">修改</label>
                            </div>


                            {/* Put this part before </body> tag */}
                            <input type="checkbox" id="my-modal" className="modal-toggle" />
                            <div className="modal">
                                <div className="modal-box">
                                    <h3 className="font-bold text-lg">修改成功</h3>
                                    <p className="py-4">请将密码妥善保管</p>
                                    <div className="modal-action">
                                        <label htmlFor="my-modal" className="btn">好!</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </CommonLayout>
    )
}

export default UserPage;