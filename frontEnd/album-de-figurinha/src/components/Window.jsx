import { useState, useRef } from "react";
import PropTypes from "prop-types";
import "./window.css";

const Window = ({ title, children, onClose }) => {
  const [isDragging, setIsDragging] = useState(false);
  const [position, setPosition] = useState({ x: 100, y: 100 });
  const windowRef = useRef(null);

  const handleMouseDown = () => {
    setIsDragging(true);
    windowRef.current.style.cursor = "grabbing";
  };

  const handleMouseUp = () => {
    setIsDragging(false);
    windowRef.current.style.cursor = "grab";
  };

  const handleMouseMove = (e) => {
    if (isDragging) {
      setPosition({
        x: e.clientX - windowRef.current.offsetWidth / 2,
        y: e.clientY - windowRef.current.offsetHeight / 2,
      });
    }
  };

  return (
    <div
      className="window"
      style={{ top: position.y, left: position.x }}
      ref={windowRef}
      onMouseMove={handleMouseMove}
      onMouseUp={handleMouseUp}
    >
      <div className="window-header" onMouseDown={handleMouseDown}>
        <span>{title}</span>
        <button onClick={onClose}>X</button>
      </div>
      <div className="window-content">{children}</div>
    </div>
  );
};

Window.propTypes = {
  title: PropTypes.string.isRequired,
  children: PropTypes.node.isRequired,
  onClose: PropTypes.func.isRequired,
};

export default Window;
