import axios from "axios";
import moment from "moment";
import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Modal, ModalHeader, ModalFooter, ModalBody, Button } from "reactstrap";
export default class Statistical extends Component {
  constructor(props) {
    super(props);
    this.state = {
      modal: false,
      dataStatistic: [],
      dataDetail:[],
      dateStart: "",
      dateEnd: "",
    };
  }

  componentDidMount() {}

  detailStatistic = async(id) =>{
    const { dateStart,dateEnd } = this.state
    const data = {
      fromDate: dateStart,
      toDate: dateEnd,
    };
    await axios.post("/statistic/"+id,data)
    .then((res) => {
      console.log("res", res);
      this.setState({
        dataDetail: res.data,
        modal:true
      });
    })
    .catch((err) => {
      console.log("err", err.response);
      alert("Lỗi không lấy được data");
    });
  }

  toggle = () => {
    this.setState({
      modal: !this.state.modal,
    });
  };
  searchStatistical = (e) => {
    e.preventDefault();
    const { dateStart, dateEnd } = this.state;
    console.log("dateStart", dateStart);
    console.log("dateEnd", dateEnd);
    if (Date.parse(dateStart) >= Date.parse(dateEnd)) {
      alert("Ngày bắt đầu phải nhỏ hơn ngày kết thúc!");
    } else {
      const data = {
        fromDate: dateStart,
        toDate: dateEnd,
      };
      axios
        .post("/statistic", data)
        .then((res) => {
          console.log("res", res);
          this.setState({
            dataStatistic: res.data,
          });
        })
        .catch((err) => {
          console.log("err", err.response);
          alert("Lỗi không lấy được data");
        });
    }
  };
  _updateField = (field) => (e) => this.setState({ [field]: e.target.value });

  viewModal = () => {
    const { dataDetail } = this.state;
    console.log("ada", this.state);
    return (
      <Modal
        isOpen={this.state.modal}
        toggle={this.toggle}
        className={this.props.className}
      >
        <ModalHeader toggle={this.toggle}>Hóa đơn thanh toán</ModalHeader>
        <ModalBody>
          {dataDetail.length>0?<table className="table table-bordered table-striped">
            <thead>
              <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày thuê</th>
                <th scope="col">Ngày trả</th>
                <th scope="col">Số lượng xe</th>
                <th scope="col">Số tiền thuê xe</th>
                <th scope="col">Số tiền phạt</th>
                <th scope="col">Tổng tiền</th>
              </tr>
            </thead>
            <tbody>
              {dataDetail.map((data,index)=>(
                <tr key={index} style={{ cursor: "pointer" }}>
                <th scope="row">{data.id}</th>
                <td>{data.name}</td>
                
                <td>{`${moment(data.startDate).format('DD/MM/YYYY')}`}</td>
                <td>{`${moment(data.endDate).format('DD/MM/YYYY')}`}</td>
                <td>{data.countVehicle}</td>
                <td>{data.totalMoney}</td>
                <td>{data.violateMoney}</td>
                <td>{data.totalMoney+data.violateMoney}</td>
              </tr>
              ))}
              
            </tbody>
          </table>:<div className="fs-2 text-center mt-5">Không có dữ liệu trong thời gian trên</div>}
          
        </ModalBody>
        <ModalFooter>
          <Button color="secondary" onClick={this.toggle}>
            Thoát
          </Button>
        </ModalFooter>
      </Modal>
    );
  };
  render() {
    const { dataStatistic } = this.state;
    return (
      <div className="row min-vh-100 mx-0 w-100">
        <div className="col-2 bg-primary px-2">
          <div className="w-100 text-center py-3 px-2 text-white fs-4 border-bottom border-white">
            Thống kê
          </div>
        </div>
        <div className="col-10 px-0">
          <div className="py-3 px-4 fs-4 border-bottom border-dark fw-bolder">
            Thống kê đối tác
          </div>
          <div className="mt-2 p-4">
            <form className="row g-3" onSubmit={this.searchStatistical}>
              <div className="col-auto">
                <label htmlFor="inputdatestart" className="col-form-label">
                  Ngày bắt đầu:
                </label>
              </div>
              <div className="col-auto">
                <input
                  type="date"
                  id="inputdatestart"
                  className="form-control"
                  name="dateStart"
                  onChange={this._updateField("dateStart")}
                />
              </div>
              <div className="col-auto">
                <label htmlFor="inputdateend" className="col-form-label">
                  Ngày kết thúc:
                </label>
              </div>
              <div className="col-auto">
                <input
                  type="date"
                  id="inputdateend"
                  className="form-control"
                  name="dateEnd"
                  onChange={this._updateField("dateEnd")}
                />
              </div>
              <div className="col-auto">
                <button type="submit" className="btn btn-primary mb-3">
                  Thống kê
                </button>
              </div>
            </form>
            {dataStatistic.length>0?<table className="table table-bordered table-striped">
              <thead>
                <tr>
                  <th scope="col">Mã</th>
                  <th scope="col">Tên</th>
                  <th scope="col">Địa chỉ</th>
                  <th scope="col">Điện thoại</th>
                  <th scope="col">Tổng lượt thuê</th>
                  <th scope="col">Tổng ngày thuê</th>
                  <th scope="col">Tổng doanh thu</th>
                </tr>
              </thead>
                <tbody>
                  {dataStatistic.map((data, index) => (
                      <tr
                        onClick={() => this.detailStatistic(data.id)}
                        style={{ cursor: "pointer" }}
                        key={index}
                      >
                        <th scope="row">{data.id}</th>
                        <td>{data.name}</td>
                        <td>{data.address}</td>
                        <td>{data.phone}</td>
                        <td>{data.turns}</td>
                        <td>{data.countDate}</td>
                        <td>{data.revenues}</td>
                      </tr>
                    ))}
                </tbody>
            </table>:<div className="fs-2 text-center mt-5">Không có dữ liệu trong thời gian trên</div>}
            
          </div>
        </div>
        {this.viewModal()}
      </div>
    );
  }
}