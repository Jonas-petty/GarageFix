/* eslint-disable react/prop-types */
import Table from "rc-table"

function RepairTable({data}) {
  
  const repairData = data.map(item => {
    return {
      key: item.id,
      name: item.name,
      phoneNumber: item.phoneNumber
    }
  })



  const columns = [
    {
      title: "Nome",
      dataIndex: "name",
      key: "name",
      width: 100,
    },
    {
      title: "Telefone",
      dataIndex: "phoneNumber",
      key: "phoneNumber",
      width: 100,
    }
  ]

  return (
    <Table columns={columns} data={repairData} />
  )
}

export default RepairTable