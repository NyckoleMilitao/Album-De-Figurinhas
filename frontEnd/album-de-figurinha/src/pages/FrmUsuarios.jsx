import { useState } from "react";
import {
  BsPencilSquare,
  BsTrash,
  BsPlus,
  BsX,
  BsCheckCircle,
} from "react-icons/bs";

function FrmUsuarios() {
  const [users, setUsers] = useState([
    { id: 1, name: "NyckoleMilitao", role: "administrador" },
    { id: 2, name: "BeatrizBarcelos", role: "autor" },
  ]);
  const [newUser, setNewUser] = useState({ name: "", role: "" });
  const [filterText, setFilterText] = useState("");
  const [editingUser, setEditingUser] = useState(null);
  const [showAddForm, setShowAddForm] = useState(false);
  const [selectedRole, setSelectedRole] = useState("");

  const roles = ["administrador", "autor", "colecionador"];

  const handleAddUser = () => {
    if (newUser.name && newUser.role) {
      const newUserList = [...users, { id: Date.now(), ...newUser }];
      setUsers(newUserList);
      setNewUser({ name: "", role: "" });
      setShowAddForm(false); // Fechar o formulário após adicionar
    } else {
      alert("Por favor, preencha todos os campos.");
    }
  };

  const handleDeleteUser = (id) => {
    const updatedUsers = users.filter((user) => user.id !== id);
    setUsers(updatedUsers);
  };

  const handleEditUser = (id) => {
    const userToEdit = users.find((user) => user.id === id);
    if (userToEdit) {
      setEditingUser({ ...userToEdit }); // Cópia do usuário para edição
      setSelectedRole(userToEdit.role); // Define o papel selecionado para edição
    }
  };

  const handleUpdateUser = () => {
    const updatedUsers = users.map((user) =>
      user.id === editingUser.id ? { ...editingUser, role: selectedRole } : user
    );
    setUsers(updatedUsers);
    setEditingUser(null);
  };

  const handleFilterUsers = (event) => {
    setFilterText(event.target.value);
  };

  const filteredUsers = users.filter((user) =>
    user.name.toLowerCase().includes(filterText.toLowerCase())
  );

  return (
    <div
      style={{
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        width: "400px",
        background: "#fff",
        padding: "40px",
        borderRadius: "5px",
        boxShadow: "0 0 10px rgba(0, 0, 0, 0.1)",
        boxSizing: "border-box",
      }}
    >
      <h1 style={{ textAlign: "center", marginBottom: "30px" }}>Usuários</h1>
      <h2
        style={{
          textAlign: "center",
          marginBottom: "30px",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        <span style={{ marginRight: "10px" }}>Novo</span>
        <BsPlus
          style={{
            cursor: "pointer",
            fontSize: "1.5rem",
            color: "#28a745",
          }}
          onClick={() => setShowAddForm(true)}
        />
      </h2>
      {showAddForm && (
        <div style={{ marginBottom: "20px" }}>
          <input
            type="text"
            placeholder="Nome"
            value={newUser.name}
            onChange={(e) => setNewUser({ ...newUser, name: e.target.value })}
            style={{
              marginBottom: "10px",
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              boxSizing: "border-box",
            }}
            required
          />
          <input
            type="text"
            placeholder="Cargo"
            value={newUser.role}
            onChange={(e) => setNewUser({ ...newUser, role: e.target.value })}
            style={{
              marginBottom: "10px",
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              boxSizing: "border-box",
            }}
            required
          />
          <BsCheckCircle
            style={{
              cursor: "pointer",
              fontSize: "1.5rem",
              color: "#28a745",
              marginRight: "10px",
            }}
            onClick={handleAddUser}
          />
          <BsX
            style={{
              cursor: "pointer",
              fontSize: "1.5rem",
              color: "#dc3545",
            }}
            onClick={() => setShowAddForm(false)}
          />
        </div>
      )}
      <div style={{ marginBottom: "20px" }}>
        <label
          htmlFor="filter"
          style={{ display: "block", marginBottom: "5px" }}
        >
          Filtrar por Nome
        </label>
        <input
          type="text"
          id="filter"
          value={filterText}
          onChange={handleFilterUsers}
          style={{
            width: "100%",
            padding: "8px",
            fontSize: "16px",
            border: "1px solid #ccc",
            borderRadius: "4px",
            boxSizing: "border-box",
          }}
        />
      </div>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {filteredUsers.map((user) => (
          <li
            key={user.id}
            style={{
              marginBottom: "10px",
              borderBottom: "1px solid #ccc",
              paddingBottom: "5px",
            }}
          >
            <div
              style={{
                display: "flex",
                justifyContent: "space-between",
                alignItems: "center",
              }}
            >
              <div>
                <strong>{user.name}</strong> - ({user.role})
              </div>
              <div>
                <BsPencilSquare
                  onClick={() => handleEditUser(user.id)}
                  style={{
                    cursor: "pointer",
                    marginRight: "10px",
                    fontSize: "1.2rem",
                    color: "#007bff",
                  }}
                />
                <BsTrash
                  onClick={() => handleDeleteUser(user.id)}
                  style={{
                    cursor: "pointer",
                    fontSize: "1.2rem",
                    color: "#dc3545",
                  }}
                />
              </div>
            </div>
          </li>
        ))}
      </ul>
      {editingUser && (
        <div style={{ marginTop: "20px" }}>
          <h3>Editar Usuário</h3>
          <input
            type="text"
            value={editingUser.name}
            onChange={(e) =>
              setEditingUser({ ...editingUser, name: e.target.value })
            }
            style={{
              marginBottom: "10px",
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              boxSizing: "border-box",
            }}
            required
          />
          <select
            value={selectedRole}
            onChange={(e) => setSelectedRole(e.target.value)}
            style={{
              marginBottom: "10px",
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              boxSizing: "border-box",
            }}
          >
            {roles.map((role) => (
              <option key={role} value={role}>
                {role}
              </option>
            ))}
          </select>
          <BsCheckCircle
            style={{
              cursor: "pointer",
              fontSize: "1.5rem",
              color: "#28a745",
              marginRight: "10px",
            }}
            onClick={handleUpdateUser}
          />
          <BsX
            style={{
              cursor: "pointer",
              fontSize: "1.5rem",
              color: "#dc3545",
            }}
            onClick={() => setEditingUser(null)}
          />
        </div>
      )}
    </div>
  );
}

export default FrmUsuarios;
