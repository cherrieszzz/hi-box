import React, { useState } from "react";
import { Avatar, Layout, Menu, Anchor, Typography, Row, Col, Card } from "antd";
import {
  PieChart,
  AreaChart,
  Area,
  Cell,
  LineChart,
  BarChart,
  Pie,
  Line,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
} from "recharts";
import CommonLayout from "../layouts/CommonLayout";
import {
  EditOutlined,
  EllipsisOutlined,
  SettingOutlined,
} from "@ant-design/icons";
import BigDataLayout from "../layouts/BigDataLayout";

const { Meta } = Card;
const { Header, Content, Sider } = Layout;
const { Link } = Anchor;
const { Title, Text, Paragraph } = Typography;
const tabList = [
  {
    key: "数据获取",
    tab: "数据获取",
  },
  {
    key: "数据存储",
    tab: "数据存储",
  },
  {
    key: "数据处理和分析",
    tab: "数据处理和分析",
  },
  {
    key: "数据可视化和呈现",
    tab: "数据可视化和呈现",
  },
  {
    key: "数据挖掘和洞察",
    tab: "数据挖掘和洞察",
  },
  {
    key: "实时处理",
    tab: "实时处理",
  },
];
const tabList1 = [
  {
    key: "tab1",
    tab: "数据管理",
  },
  {
    key: "tab2",
    tab: "数据质量",
  },
  {
    key: "tab3",
    tab: "数据隐私和安全",
  },
  {
    key: "tab4",
    tab: "数据分析和处理能力",
  },
  {
    key: "tab5",
    tab: "数据集成和互操作性",
  },
  {
    key: "tab6",
    tab: "多样化的数据类型",
  },
  {
    key: "tab7",
    tab: "带宽和存储成本",
  },
  {
    key: "tab8",
    tab: "法律和伦理问题",
  },
];
const contentList1 = {
  tab1: (
    <p>
      大数据涉及海量的数据，对数据的存储、索引、清洗和管理提出了巨大的挑战。有效地管理大规模数据的存储和访问成为关键问题。
    </p>
  ),
  tab2: (
    <p>
      大数据中可能存在数据质量问题，包括缺失数据、不准确数据、重复数据等。保证数据的准确性和完整性是一个挑战。
    </p>
  ),
  tab3: (
    <p>
      大数据中可能包含敏感信息，保护数据隐私和确保数据安全是一个重要的挑战。数据的收集、存储和传输需要采取合适的安全措施，以防止数据泄露和未经授权的访问。
    </p>
  ),
  tab4: (
    <p>
      大数据需要处理和分析海量的数据，需要高效的计算和处理能力。处理大规模数据的算法和技术需要不断创新和优化。
    </p>
  ),
  tab5: (
    <p>
      大数据环境中可能存在多个数据源和数据格式，需要解决数据集成和互操作性的问题。确保不同数据源之间的数据能够有效地集成和共享是一个挑战。
    </p>
  ),
  tab6: (
    <p>
      大数据涵盖了结构化数据、半结构化数据和非结构化数据等多种数据类型。处理和分析不同类型的数据需要适应不同的技术和工具。
    </p>
  ),
  tab7: (
    <p>
      大数据的传输、存储和处理需要消耗大量的带宽和存储资源，对网络和存储基础设施提出了挑战。
    </p>
  ),
  tab8: (
    <p>
      大数据的使用涉及到法律和伦理方面的问题，包括数据隐私、数据所有权、数据使用合规性等。确保在大数据处理和分析过程中遵守法律法规和伦理规范是一个挑战。
    </p>
  ),
};
const contentList = {
  数据获取: (
    <p>
      大数据的工作开始于数据的获取阶段。数据可以来自各种来源，包括传感器、日志文件、社交媒体、交易记录等。这些数据可以通过数据采集工具、API接口或数据集成平台等方式收集。
    </p>
  ),
  数据存储: (
    <p>
      获取的数据需要进行存储以供后续处理和分析。在大数据环境中，常用的数据存储方式包括数据湖和数据仓库。数据湖是一个存储原始、未处理的数据的集合，可以包含结构化数据、半结构化数据和非结构化数据。数据仓库则是一个用于存储已经处理和转换成结构化形式的数据的集合，通常用于支持业务报表和分析。
    </p>
  ),
  数据处理和分析: (
    <p>
      大数据的处理和分析通常涉及大规模的数据集和复杂的计算任务。常用的处理和分析框架包括Hadoop和Spark等。这些框架提供了分布式计算能力，可以将数据分成多个块进行并行处理，以加速处理速度。数据处理和分析的任务可以包括数据清洗、转换、聚合、模式识别、机器学习等。
    </p>
  ),
  数据可视化和呈现: (
    <p>
      处理和分析后的结果可以通过数据可视化工具和技术进行展示和呈现。数据可视化可以将复杂的数据转化为易于理解和解释的图表、图形或仪表盘等形式，帮助用户发现数据中的模式、趋势和见解。
    </p>
  ),
  数据挖掘和洞察: (
    <p>
      通过对大数据的处理和分析，可以发现隐藏在数据中的有价值的信息和洞察。数据挖掘技术可以应用于大数据，以识别模式、建立预测模型、进行聚类分析、关联分析等。
    </p>
  ),
  实时处理: (
    <p>
      通过对大数据的处理和分析，可以发现隐藏在数据中的有价值的信息和洞察。数据挖掘技术可以应用于大数据，以识别模式、建立预测模型、进行聚类分析、关联分析等。
    </p>
  ),
};
const data = [
  { year: "2000", 迭代更新: 200 },
  { year: "2005", 迭代更新: 400 },
  { year: "2010", 迭代更新: 800 },
  { year: "2015", 迭代更新: 1200 },
  { year: "2020", 迭代更新: 1600 },
];
const jobData = [
  { name: "2018", year: "Java后端开发", job: 10053 },
  { name: "2019", year: "Python人工智能", job: 15003 },
  { name: "2020", year: "物联网开发", job: 18200 },
  { name: "2021", year: "Untiy游戏开发", job: 20005 },
  { name: "2022", year: "大数据分析", job: 23000 },
];
const data1 = [
  { name: "Group A", value: 400 },
  { name: "Group B", value: 300 },
  { name: "Group C", value: 300 },
  { name: "Group D", value: 200 },
];

const COLORS = ["#0088FE", "#00C49F", "#FFBB28", "#FF8042", "#00FFFF"];
const job = [
  {
    year: "2018",
    Java后端开发: 10000,
    Python人工智能: 11240,
    物联网开发: 12111,
    Untiy游戏开发: 12354,
    大数据分析: 12600,
  },
  {
    year: "2019",
    Java后端开发: 9800,
    Python人工智能: 13020,
    物联网开发: 11268,
    Untiy游戏开发: 14231,
    大数据分析: 13622,
  },
  {
    year: "2020",
    Java后端开发: 11000,
    Python人工智能: 12598,
    物联网开发: 16523,
    Untiy游戏开发: 12411,
    大数据分析: 14210,
  },
  {
    year: "2021",
    Java后端开发: 11500,
    Python人工智能: 13958,
    物联网开发: 19236,
    Untiy游戏开发: 12111,
    大数据分析: 14000,
  },
  {
    year: "2022",
    Java后端开发: 9500,
    Python人工智能: 14152,
    物联网开发: 15713,
    Untiy游戏开发: 13211,
    大数据分析: 14555,
  },
];

const App = () => {
  const [activeTabKey1, setActiveTabKey1] = useState("数据获取");
  const [activeTabKey11, setActiveTabKey11] = useState("tab1");
  const onTab1Change1 = (key) => {
    setActiveTabKey11(key);
  };
  const [currentMenuItem, setCurrentMenuItem] = useState("定义");
  const onTab1Change = (key) => {
    setActiveTabKey1(key);
  };
  const handleMenuClick = (e) => {
    setCurrentMenuItem(e.key);
  };

  return (
    <BigDataLayout>
      <div>
        <Layout style={{ minHeight: "100vh" }}>
        
              <Sider>
                <Menu
                  theme="dark"
                  selectedKeys={[currentMenuItem]}
                  onClick={handleMenuClick}
                  style={{position:'fixed', left:0}}
                >
                  <Menu.Item key="5" title="大数据的历史">
                    <Link href="#5" title="大数据的历史" />
                  </Menu.Item>
                  <Menu.Item key="1" title="大数据的定义">
                    <Link href="#1" title="大数据的定义" />
                  </Menu.Item>
                  <Menu.Item key="3" title="大数据分析就业前景">
                    <Link href="#3" title="大数据分析就业前景" />
                  </Menu.Item>
                  <Menu.Item key="4" title="大数据生态">
                    <Link href="#4" title="大数据生态" />
                  </Menu.Item>
                  <Menu.Item key="6" title="大数据的使用场景">
                    <Link href="#6" title="大数据的使用场景" />
                  </Menu.Item>
                  <Menu.Item key="7" title="大数据的工作原理">
                    <Link href="#7" title="大数据的工作原理" />
                  </Menu.Item>
                  <Menu.Item key="8" title="大数据的挑战">
                    <Link href="#8" title="大数据的挑战" />
                  </Menu.Item>
                </Menu>
              </Sider>
        

          <Layout className="w-4/5">
            <Content style={{ padding: "24px" }}>
              <div id="5">
                <Title level={3}>历史</Title>
                <Paragraph>
                  <Text>
                    2000年，有人开始使用<b>" Big Data "</b>
                    这个词。2012年，IBM以及政府、科研机构纷纷将大数据视为自己未来的重点领域。2013年，美国总统奥巴马发表重要演讲，推出了“大数据倡议计划”，推动大数据产业迅速发展。
                  </Text>
                </Paragraph>
                <Row>
                  <Col span={8}>
                    <PieChart width={400} height={300}>
                      <Pie
                        data={data}
                        dataKey="迭代更新"
                        nameKey="year"
                        cx="50%"
                        cy="50%"
                        outerRadius={80}
                        fill="#8884d8"
                        label
                      />
                      <Tooltip />
                      <Legend />
                    </PieChart>
                  </Col>
                  <Col span={12}>
                    <BarChart width={500} height={300} data={data}>
                      <XAxis dataKey="year" />
                      <YAxis dataKey="迭代更新"></YAxis>
                      <Tooltip />
                      <Legend />
                      <Bar dataKey="迭代更新" fill="#8884d8" />
                    </BarChart>
                  </Col>
                </Row>
              </div>
              <br></br>
              <div id="5">
                <Title level={3}>定义</Title>
                <Paragraph>
                  <Text>
                    大数据由巨型数据集组成，这些数据集规模超出了常用软件在可接受时间下的收集、管理、处理和使用能力。大数据是指数据量大、数据类型多样、数据处理速度等方面都非常具有挑战性的数据。
                  </Text>
                  <Row style={{display:"flex",justifyContent:"space-around",width:"100%",padding:'3rem 2rem'}}>
                    <Card
                      title="大数据优势"
                      bordered={false}
                      style={{ width: 250 }}
                    >
                      <ul>
                        <li>数据量大</li>
                        <li>数据类型多样</li>
                        <li>处理速度快</li>
                        <li>价值密度广泛</li>
                        <li>数据可信度高</li>
                      </ul>
                    </Card>
                    <Card
                      title="大数据特性"
                      bordered={false}
                      style={{ width: 250 }}
                    >
                      <ul>
                        <li> 规模性（Volume）</li>
                        <li>多样性（Varity）</li>
                        <li>高速性（Velocity）</li>
                        <li>价值性（Value）</li>
                      </ul>
                    </Card>
                    <Card
                      title="大数据发展趋势"
                      bordered={false}
                      style={{ width: 250 }}
                    >
                      <ul>
                        <li>将呈现指数级增长</li>
                        <li>将成为最有价值的资源</li>
                        <li>传统行业智能融合</li>
                        <li>数据将越来越开放</li>
                        <li>大数据安全将日受重视</li>
                        <li>大数据人才将备受欢迎</li>
                      </ul>
                    </Card>
                  </Row>
                </Paragraph>
              </div>
              <div id="3">
                <Title level={3}>就业前景</Title>
                <Paragraph>
                  <p>
                    <b>
                      随着国家重视大数据，政府扶持大数据，大数据在企业中生根发芽，开花结果。未来三至五年，中国需要180万数据人才，但目前只有约30万人。
                    </b>
                  </p>
                  <p>
                    前程无忧大数据岗位搜索，共29854个职位满足条件；智联招聘大数据岗位搜索，共27627个职位满足条件；猎聘网大数据岗位搜索，共1000+个职位满足条件；拉勾网大数据岗位搜索，共500+个职位满足条件。
                  </p>
                  <p>
                    <ul>
                      <li>
                        <b>人才缺口：</b>
                        未来3至5年，中国需要200万+大数据人才，目前大数据从业人数不足50万，市场需要远远得不到满足。总结来说就是，未来大数据人才缺口会越来越大，缺的人多了，自然好就业。
                      </li>
                      <li>
                        <b>职位薪资：</b>
                        普通大数据开发工程师的基本岗位薪资起步即1万+，一般入职薪资13000元左右，3年以上工作大数据开发工程师薪资高达30000元/月。
                      </li>
                      <li>
                        <b>行业前景：</b>
                        未来大数据与云计算、AI相结合，将缔造数百个就业新岗位。说白了就是行业前景可观，未来可期{" "}
                      </li>
                      <li>
                        <b>实际问题：</b>
                        企业需求，BAT，滴滴，今日头条重金招贤纳士，急寻大数据人才，校招年薪水平均在40万以上，80%中小型企业大数据建设已经起步，需求量大增。有大企业需求，未来就业前景自然不言而喻。
                      </li>
                    </ul>
                  </p>
                  <Title level={5}>
                    <p align="center">
                      <b>近五年大数据就业形势</b>
                    </p>
                  </Title>
                  <Row style={{display:"flex", width:'100%', justifyContent:"space-around"}}>
                    <Col style={{}}>
                      <AreaChart
                        width={450}
                        height={300}
                        data={job}
                        margin={{ top: 10, right: 30, left: 0, bottom: 0 }}
                      >
                        <defs>
                          <linearGradient
                            id="colorUv"
                            x1="0"
                            y1="0"
                            x2="0"
                            y2="1"
                          >
                            <stop
                              offset="5%"
                              stopColor="#8884d8"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="20%"
                              stopColor="#82ca9d"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="30%"
                              stopColor="#800080"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="40%"
                              stopColor="#FFA500"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="5%"
                              stopColor="#00FF00"
                              stopOpacity={0.05}
                            />
                          </linearGradient>
                          <linearGradient
                            id="colorPv"
                            x1="0"
                            y1="0"
                            x2="0"
                            y2="1"
                          >
                            <stop
                              offset="5%"
                              stopColor="#8884d8"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="20%"
                              stopColor="#82ca9d"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="30%"
                              stopColor="#800080"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="40%"
                              stopColor="#FFA500"
                              stopOpacity={0.2}
                            />
                            <stop
                              offset="5%"
                              stopColor="#00FF00"
                              stopOpacity={0.05}
                            />
                          </linearGradient>
                        </defs>
                        <XAxis dataKey="year" />
                        <YAxis />
                        <CartesianGrid strokeDasharray="3 3" />
                        <Tooltip />
                        <Area
                          type="monotone"
                          dataKey="Java后端开发"
                          stroke="#8884d8"
                          fillOpacity={1}
                          fill="url(#colorUv)"
                        />
                        <Area
                          type="monotone"
                          dataKey="Python人工智能"
                          stroke="#82ca9d"
                          fillOpacity={1}
                          fill="url(#colorPv)"
                        />
                        <Area
                          type="monotone"
                          dataKey="物联网开发"
                          stroke="#800080"
                          fillOpacity={1}
                          fill="url(#colorUv)"
                        />
                        <Area
                          type="monotone"
                          dataKey="Untiy游戏开发"
                          stroke="#FFA500"
                          fillOpacity={1}
                          fill="url(#colorPv)"
                        />
                        <Area
                          type="monotone"
                          dataKey="大数据分析"
                          stroke="#00FF00"
                          fillOpacity={1}
                          fill="url(#colorUv)"
                        />
                      </AreaChart>
                    </Col>
                    <Col style={{}}>
                      <BarChart width={500} height={300} data={job}>
                        <XAxis dataKey="year" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Bar dataKey="Java后端开发" fill="#8884d8" />
                        <Bar dataKey="Python人工智能" fill="#82ca9d" />
                        <Bar dataKey="物联网开发" fill="#800080 " />
                        <Bar dataKey="Untiy游戏开发" fill="#FFA500" />
                        <Bar dataKey="大数据分析" fill="#00FF00" />
                      </BarChart>
                    </Col>
                  </Row>
                </Paragraph>
              </div>
              <div id="4">
                <Title level={3}>生态</Title>
                <Paragraph>
                  <b>
                    大数据的生态是指在大数据领域中涌现出的一系列相关技术、工具、平台和解决方案的集合，以支持大数据的存储、处理、分析和应用。
                  </b>
                  <p>大数据的生态系统通常包括以下组成部分：</p>
                  <ul>
                    <li>
                      <b>数据采集和存储：</b>
                      包括数据采集、传输和存储技术，如传感器、物联网设备、日志收集工具、数据湖和数据仓库等，用于收集和存储大规模的数据。
                    </li>
                    <li>
                      <b>数据处理和分析：</b>
                      涉及数据处理和分析的工具和技术，如分布式计算框架（例如Hadoop、Spark）、流处理框架（例如Kafka、Flink）、数据挖掘和机器学习算法等，用于处理和分析大规模的数据。
                    </li>
                    <li>
                      <b>数据安全和隐私：</b>
                      关注数据安全和隐私保护的技术和策略，如数据加密、访问控制、身份认证和数据脱敏等，以确保大数据的安全性和合规性。
                    </li>
                    <li>
                      <b>数据应用和场景：</b>
                      大数据的应用领域和场景，涵盖了各行业的数据驱动应用，如金融风控、智能城市、医疗健康、电子商务等，以及特定领域的解决方案和平台。
                    </li>
                    <li>
                      <b>开源社区和商业厂商：</b>
                      大数据生态系统中的开源社区和商业厂商共同推动了技术的发展和创新，提供了各种工具、平台和解决方案，如
                      <b>
                        Apache基金会、Hortonworks、Cloudera、Amazon Web
                        Services、Google Cloud
                      </b>
                      等。
                    </li>
                  </ul>
                  <Row gutter={16}>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://download.logo.wine/logo/Apache_HTTP_Server/Apache_HTTP_Server-Logo.wine.png"
                          />
                        }
                      >
                        <Meta
                          title="Apache基金会"
                          description="专门为支持开源软件项目而办的一个非盈利性组织。在它所支持的 Apache 项目与子项目中，所发行的软件产品都遵循 Apache 许可证（Apache License）。"
                        />
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://www.channelbiz.de/wp-content/uploads/2016/11/hortonworks-logo-684x513.jpg"
                          />
                        }
                      >
                        <Meta
                          title="Hortonworks"
                          description="HDP 可以满足各种静态数据用例需求，
                          支持实时客户应用，交付强大的分析能力，从而加快决
                          策和创新。 "
                        />
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://www.eigenmagic.com/wp-uploads/2015/05/cloudera-logo-3.jpg"
                          />
                        }
                      >
                        <Meta
                          title="Cloudera"
                          description="Cloudera提供一个可扩展，灵活的，大数据管理平台，可用来方便地管理你的企业中快速增长的多种多样的数据。"
                        />
                      </Card>
                    </Col>
                  </Row>
                  <br></br>
                  <Row gutter={16}>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://www.zdnet.de/wp-content/uploads/2015/04/Amazon-Web-Services.jpg"
                          />
                        }
                      >
                        <Meta
                          title="Amazon Web Services"
                          description="云计算通过互联网按需提供IT资源,计算能力、存储和数据库，而无需购买、拥有和维护物理数据中心及服务器。"
                        />
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://mumbrella.com.au/wp-content/uploads/2019/07/Google-Cloud.png"
                          />
                        }
                      >
                        <Meta
                          title="Google Cloud"
                          description="Google Cloud Platform 为计算大数据、机器学习和物联网（IoT）以及云管理、安全和开发人员工具提供服务。"
                        />
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card
                        style={{ width: 300 }}
                        cover={
                          <img
                            alt="example"
                            src="https://www.nixp.ru/uploads/news/fullsize_image/8de9972c3b141d432417dc3f57e3247e1e75857a.png"
                          />
                        }
                      >
                        <Meta
                          title="Hadoop"
                          description="Hadoop 是一个由 Apache 基金会所开发的分布式系统基础架构。解决海量数据的存储和海量数据的分析计算问题。"
                        />
                      </Card>
                    </Col>
                  </Row>
                </Paragraph>
              </div>

              <div id="6">
                <Title level={3}>使用场景</Title>
                <Paragraph>
                  <Row gutter={16}>
                    <Col span={8}>
                      <Card title="金融行业" bordered={false}>
                        用于金融风险管理、欺诈检测、交易分析、客户行为分析、个性化推荐和智能投资决策等方面。
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card title="零售和电子商务" bordered={false}>
                        帮助零售商分析销售数据、用户购买行为、库存管理、供应链优化、个性化营销和价格优化等。
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card title="医疗健康领域" bordered={false}>
                        用于医疗记录管理、临床决策支持、药物研发、疾病预测和监测、健康管理和个性化治疗等方面。
                      </Card>
                    </Col>
                  </Row>
                  <br></br>
                  <Row gutter={16}>
                    <Col span={8}>
                      <Card title="物联网" bordered={false}>
                        可以处理来自物联网设备和传感器的海量数据，用于智能城市、智能交通、和农业领域。
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card title="能源和公共事业" bordered={false}>
                        帮助能源公司优化能源生产和分配、智能电网管理、能源消耗预测和公共事业管理等。
                      </Card>
                    </Col>
                    <Col span={8}>
                      <Card title="交通和物流" bordered={false}>
                        用于交通流量分析、交通优化、智能交通管理、物流路线规划和货运跟踪等方面。
                      </Card>
                    </Col>
                  </Row>
                </Paragraph>
              </div>
              <br></br>
              <div id="7">
                <Title level={3}>工作原理</Title>
                <Paragraph>
                  <Card
                    style={{
                      width: "100%",
                    }}
                    title="工作原理"
                    tabList={tabList}
                    activeTabKey={activeTabKey1}
                    onTabChange={onTab1Change}
                  >
                    {contentList[activeTabKey1]}
                  </Card>
                  <br />
                </Paragraph>
              </div>
              <div id="8">
                <Title level={3}>挑战</Title>
                <Paragraph>
                  <Card
                    style={{
                      width: "100%",
                    }}
                    title="工作原理"
                    tabList={tabList1}
                    activeTabKey={activeTabKey11}
                    onTabChange={onTab1Change1}
                  >
                    {contentList1[activeTabKey11]}
                  </Card>
                  <br />
                </Paragraph>
              </div>
            </Content>
          </Layout>
        </Layout>
      </div>
    </BigDataLayout>
  );
};

export default App;
