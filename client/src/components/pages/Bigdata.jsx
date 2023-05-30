import React, { useState } from 'react';
import { Layout, Menu, Anchor, Typography } from 'antd';
import { PieChart, LineChart, BarChart, Pie, Line, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import CommonLayout from '../layouts/CommonLayout'
const { Header, Content, Sider } = Layout;
const { Link } = Anchor;
const { Title, Text, Paragraph } = Typography;
const data = [
  { name: '数据1', value: 400 },
  { name: '数据2', value: 300 },
  { name: '数据3', value: 300 },
  { name: '数据4', value: 200 },
  { name: '数据5', value: 100 },
];

const App = () => {
  const [currentMenuItem, setCurrentMenuItem] = useState('定义');

  const handleMenuClick = (e) => {
    setCurrentMenuItem(e.key);
  };

  return (
    <CommonLayout>
      <div>


        <Layout style={{ minHeight: '100vh' }}>
          <Sider>
            <Menu theme="dark" selectedKeys={[currentMenuItem]} onClick={handleMenuClick}>
              <Menu.Item key="1" title="大数据的定义" >
                <Link href="#1" title="大数据的定义" />
              </Menu.Item>
              <Menu.Item key="2" title="大数据的特性" >
                <Link href="#2" title="大数据的特性" />
              </Menu.Item>
              <Menu.Item key="3" title="大数据分析就业前景">
                <Link href="#3" title="大数据分析就业前景" />
              </Menu.Item>
              <Menu.Item key="4" title="大数据生态">
                <Link href="#4" title="大数据生态" />
              </Menu.Item>
              <Menu.Item key="5" title="大数据的历史">
                <Link href="#5" title="大数据的历史" />
              </Menu.Item>
              <Menu.Item key="6" title="大数据的使用场景">
                <Link href="#6" title="大数据的使用场景" />
              </Menu.Item>
              <Menu.Item key="7" title="大数据的工作原理" >
                <Link href="#7" title="大数据的工作原理" />
              </Menu.Item>
              <Menu.Item key="8" title="大数据的挑战" >
                <Link href="#8" title="大数据的挑战" />
              </Menu.Item>
            </Menu>

          </Sider>
          <Layout>

            <Content style={{ padding: '24px' }}>
              <div id="1">
                <Title level={3}>大数据的定义</Title>
                <Paragraph>
                  <Text>大数据是指数据量大、数据类型多样、数据处理速度等方面都非常具有挑战性的数据。它具有以下特点：</Text>
                  <ul>
                    <li>数据量大</li>
                    <li>数据类型多样</li>
                    <li>处理速度快</li>
                    <li>价值密度低</li>
                    <li>数据可信度不高</li>
                  </ul>
                  <Title level={3}>大数据的历史</Title>
                  <Text>2000年，有人开始使用”big data”这个词。2012年，IBM以及政府、科研机构纷纷将大数据视为自己未来的重点领域。2013年，美国总统奥巴马发表重要演讲，推出了“大数据倡议计划”，推动大数据产业迅速发展。</Text>
                </Paragraph>
              </div>
              <div id="2">
                <Title level={3}>大数据的特性</Title>
                <Paragraph>
                  这里是大数据的特性的内容。
                </Paragraph>
              </div>
              <div id="3">
                <Title level={3}>大数据分析就业前景</Title>
                <Paragraph>
                  这里是大数据分析就业前景的内容。
                </Paragraph>
              </div>
              <div id="4">
                <Title level={3}>大数据生态</Title>
                <Paragraph>
                  这里是大数据生态的内容。
                </Paragraph>
              </div>
              <div id="5">
                <Title level={3}>大数据的历史</Title>
                <Paragraph>
                  这里是大数据的历史的内容。
                </Paragraph>
              </div>
              <div id="6">
                <Title level={3}>大数据的使用场景</Title>
                <Paragraph>
                  这里是大数据的使用场景的内容。
                </Paragraph>
              </div>
              <div id="7">
                <Title level={3}>大数据的工作原理</Title>
                <Paragraph>
                  这里是大数据的工作原理的内容。
                </Paragraph>
              </div>
              <div id="8">
                <Title level={3}>大数据的挑战</Title>
                <Paragraph>
                  这里是大数据的挑战的内容。
                </Paragraph>
              </div>
            </Content>
          </Layout>
        </Layout >
      </div>
    </CommonLayout>
  );
};

export default App;