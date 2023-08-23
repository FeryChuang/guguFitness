// memberManagement.js



export class  MemberManagement {
    constructor() {
        this.membersData = [];
    }

    initMembersTable() {
        const tableContainer = document.getElementById('membersTable');
        tableContainer.innerHTML = '';

        this.membersData.forEach(member => {
            const row = document.createElement('div');
            row.className = 'row mb-3 themed-grid-col';
            row.innerHTML = `
                <div class="col-md-2">${member.id}</div>
                <div class="col-md-2">${member.account}</div>
                <div class="col-md-2">${member.password}</div>
                <div class="col-md-2">${member.name}</div>
                <div class="col-md-2">${member.email}</div>
            `;
            tableContainer.appendChild(row);
        });
    }

    addMember() {
        const memberId = document.getElementById('memberId').value;
        const account = document.getElementById('account').value;
        const password = document.getElementById('password').value;
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;

        this.membersData.push({ id: parseInt(memberId), account, password, name, email });

        this.initMembersTable();
        this.resetForm();
    }

    updateMember() {
        const memberId = document.getElementById('memberId').value;
        const account = document.getElementById('account').value;
        const password = document.getElementById('password').value;
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;

        const existingMember = this.membersData.find(member => member.id === parseInt(memberId));
        if (existingMember) {
            existingMember.account = account;
            existingMember.password = password;
            existingMember.name = name;
            existingMember.email = email;
        }

        this.initMembersTable();
        this.resetForm();
    }

    deleteMember() {
        const memberId = document.getElementById('memberId').value;

        const index = this.membersData.findIndex(member => member.id === parseInt(memberId));
        if (index !== -1) {
            this.membersData.splice(index, 1);
        }

        this.initMembersTable();
        this.resetForm();
    }

    resetForm() {
        document.getElementById('memberId').value = '';
        document.getElementById('account').value = '';
        document.getElementById('password').value = '';
        document.getElementById('name').value = '';
        document.getElementById('email').value = '';
    }

    showConfirmation(action) {
        let message = '';
        switch (action) {
            case 'add':
                message = '確定要新增會員嗎？';
                break;
            case 'update':
                message = '確定要修改會員嗎？';
                break;
            case 'delete':
                message = '確定要刪除會員嗎？';
                break;
            default:
                break;
        }

        if (confirm(message)) {
            switch (action) {
                case 'add':
                    this.addMember();
                    break;
                case 'update':
                    this.updateMember();
                    break;
                case 'delete':
                    this.deleteMember();
                    break;
                default:
                    break;
            }
        }
    }
}


