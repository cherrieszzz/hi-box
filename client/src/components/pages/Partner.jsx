import React from 'react'
import CommonLayout from '../layouts/CommonLayout'
import haut_logo from '../../assets/haut_logo.png'
import zzuli_logo from '../../assets/zzuli_logo.png'
import hati_logo from '../../assets/hati_logo.png'
import pony_logo from '../../assets/pony_logo.png'
import huahe_logo from '../../assets/huahe_logo.png'
import wbgj_logo from '../../assets/wbgj_logo.png'
import wbwl_logo from '../../assets/wbwl_logo.png'

function PartnerLayer() {

  function PartnerCard({ partner }) {
    return (
      <div className='w-full h-full py-3 flex justify-center items-center bg-gray-200 '>
        <img src={partner.img} alt={partner.name} className='max-h-[5rem] max-w-[12rem]' />
      </div>
    )
  }
//1.高校：河南工业大学、郑州轻工业大学、河南牧业经济学院、河南应用技术职业学院
//2.企业：谱尼测试、万邦物流、河南万邦国际农产品物流股份有限公司
  const partnerSchoolData = [
    {
      name: 'haut',
      img: haut_logo,
    },
    {
      name: 'zzuli',
      img: zzuli_logo,
    },
    {
      name: 'huahe',
      img: huahe_logo,
    },
    {
      name: 'hati',
      img: hati_logo
    }
  ]

  const partnerMerchantData = [
    {
      name: 'pony',
      img: pony_logo,
    },
    {
      name: 'wbgj',
      img: wbgj_logo,
    },
    {
      name: 'wbwl',
      img: wbwl_logo,
    }    
  ]

  return (
    <div className='container w-sm mx-auto my-[15rem]'>
      <div className='max-w-[50rem] mx-auto'>
        <div className='w-full flex justify-center'>
        <h2 className='font-black text-lg'>合作伙伴</h2>
        </div>
  
        <h3>合作高校</h3>
        <div className='grid grid-cols-3 gap-1 grid-flow-row max-w-[50rem] mx-auto'>
          {
            partnerSchoolData.map((partner) => {
              return (
                <p>
                  <PartnerCard partner={partner} />
                </p>
              )
            })
          }
        </div>
        <div>
          <p>① 河南工业大学（Henan University of Technology），位于河南省郑州市，是河南省人民政府和国家粮食局共建高校、
            河南省特色骨干大学建设高校、教育部本科教学工作水平评估优秀高校 、中国政府奖学金来华留学生接收院校，入选2011计划、
            国家级新工科研究与实践项目 、中西部高校基础能力建设工程、卓越工程师教育培养计划、卓越农林人才教育培养计划、
            国家级大学生创新创业训练计划、国家级专业技术人员继续教育基地。</p>
          <p>
            ② 郑州轻工业大学（Zhengzhou University of Light Industry），位于河南省郑州市，是中央与地方共建、
            以地方管理为主的河南省特色骨干大学，是河南省人民政府和国家烟草专卖局共建高校，是博士学位授予单位；
            入选国家教育强国推进工程、卓越工程师教育培养计划、国家级新工科研究与实践项目、
            国家级大学生创新创业训练计划、全国毕业生就业典型经验高校。
          </p>
          <p>
            ③ 河南牧业经济学院（Henan University of Animal Husbandry and Economy），简称河南牧院，位于河南省郑州市，始建于1957年，
            由原郑州牧业工程高等专科学校（1957年建校）和原河南商业高等专科学校（1960年建校）于2013年合并组建而成，
            是省属公办全日制普通本科院校、河南省本科转型发展试点学校、河南省“三全育人”综合改革试点高校、河南省首批创业教育示范校、
            河南省大数据双创基地、河南省2019年度智慧校园建设试点高校，是河南省草畜产业技术创新联盟和河南省智慧畜牧业产业技术创新联盟理事长单位、
            国家畜牧科技创新联盟常务理事单位、河南畜牧兽医学会副理事长单位、河南省知识产权研究会常务理事单位。
          </p>
          <p>
            ④ 河南应用技术职业学院是直属于河南省教育厅的一所全日制公办普通高等职业院校。学校现已形成“一校、
            两地（郑州市、开封市）、三校区（郑州校区、开封北院校区、开封南院校区）”的办学格局，主校区在郑州市中原区。
            学校始建于1956年，前身是河南省化学工业学校，2010年转制为高等职业院校，2015年与原河南省医药学校合并更名为河南应用技术职业学院。
            学校是河南省省级骨干高职院校、省级品牌示范院校，省级优质高等职业院校，河南省高水平高等职业院校和高水平专业群建设单位。
            学校总占地面积875亩，建筑面积30.97万平方米，校内实训基地121个，各类图书资源总量达545.22万册。
            学校面向全国招生，设有9个二级学院，1个本科部（与郑州轻工业大学联办），5个教学部（中心），全日制在校生达19000余人。
            建校以来，学校已为社会培养输送了8.1万余名高端应用型技术技能人才，培训各类从业人员6万余人次。
          </p>
        </div>
        <h3>合作企业</h3>
        <div className='grid grid-cols-3 gap-1 grid-flow-row max-w-[50rem] mx-auto'>
          {
            partnerMerchantData.map((partner) => {
              return (
                <p>
                  <PartnerCard partner={partner} />
                </p>
              )
            })
          }
        </div>
        <div>
        <p>① 谱尼测试集团创立于2002年，集团总部位于北京，现已发展成为拥有8000余名员工，30个大型实验基地及100余家全资子、
          分公司组成的服务网络遍布全国的大型综合性检测集团。2020年9月16日，谱尼测试成功在深圳证券交易所创业板发行上市，
          公司股票代码为300887。谱尼测试集团是经国家发改委、科技部、海关总署联合评定发文认定的国家级企业技术中心、
          北京市批准的生物医药类工程实验室、北京市科委认定的工程技术研究中心、北京市经信委认定的企业技术中心</p>
          <p>
            ② 万邦国际集团成立于2001年，总部位于河南省郑州市，以“立足三农、保障民生、服务全国”为宗旨，
            业务涵盖综合性农产品冷链物流、高效生态农业开发、生鲜连锁超市、跨境电子商务、进出口贸易等农业全产业链。
            荣获重点龙头企业、全国农产品“综合十强市场”、“星创天地”、全国“万企帮万村”精准扶贫先进民营企业等荣誉称号。
          </p>
          <p>
            ③ 万邦物流平台致力于打造物流行业的信息搜索平台，为广大货主提供国内及国际物流信息查询服务，
            共建物流行业的信息共享平台。查物流，上万邦。
          </p>
        </div>
      </div>
    </div>
  )
}

const Partner = () => {
  return (
    <CommonLayout>
    <div>
      <PartnerLayer />
    </div>
    </CommonLayout>
  )
}

export default Partner