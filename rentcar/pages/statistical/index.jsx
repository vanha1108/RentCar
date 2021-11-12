import React, { Component } from "react";
import { Modal, ModalHeader, ModalFooter, ModalBody, Button } from "reactstrap";

export default class Statistical extends Component {
  constructor(props) {
    super(props);
    this.state = {
      modal: false,
      dateStart:"",
      dateEnd:""
    };
  }

  toggle = () => {
    this.setState({
      modal: !this.state.modal,
    });
  };
  search = (e) =>{
    e.preventDefault();
    const { dateStart,dateEnd} = this.state
    console.log('dateStart',dateStart);
    console.log('dateEnd',dateEnd);
    if(Date.parse(dateStart)>=Date.parse(dateEnd)){
        alert("Ngày bắt đầu phải nhỏ hơn ngày kết thúc!")
    }
  }
  _updateField = (field) => (e) => this.setState({ [field]: e.target.value });

  viewModal = () => {
    return (
      <Modal
        isOpen={this.state.modal}
        toggle={this.toggle}
        className={this.props.className}
      >
        <ModalHeader toggle={this.toggle}>Hóa đơn thanh toán</ModalHeader>
        <ModalBody>
          <table className="table table-bordered table-striped">
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
              <tr style={{ cursor: "pointer" }}>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>@mdo</td>
              </tr>
            </tbody>
          </table>
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
    return (
      <div className="row min-vh-100 mx-0">
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
            <form className="row g-3" onSubmit={this.search}>
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
            <table className="table table-bordered table-striped">
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
                <tr
                  onClick={() =>
                    this.setState({
                      modal: true,
                    })
                  }
                  style={{ cursor: "pointer" }}
                >
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        {this.viewModal()}
      </div>
    );
  }
}
