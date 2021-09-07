const DataTable = () => {
    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Salesperson</th>
                        <th>Visited Customers</th>
                        <th>Successful Dealings</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>04/21/2021</td>
                        <td>Barry Allen</td>
                        <td>34</td>
                        <td>25</td>
                        <td>15017.00</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default DataTable;