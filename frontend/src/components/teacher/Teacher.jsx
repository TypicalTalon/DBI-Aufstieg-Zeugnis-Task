import React,{useEffect, useState} from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { AppBar, Button, Toolbar } from '@mui/material';
import { useNavigate } from 'react-router-dom';


function Teacher() {
    const [teachers, setTeacher] = useState([])
    const [id, setId] = useState();
    const [version, setVersion] = useState();
    const [firstname,setFirstname]= useState();
    const [lastname,setLastname] = useState();
    let navigate = useNavigate()


    useEffect(()=>{ 
        fetch("http://localhost:8080/teacher/",{
          method:"GET"
        })
        .then(resposne => resposne.json())
        .then(data => setTeacher(data))
    },[])
   

    async function deleteE(id){
      let result = await fetch("http://localhost:8080/teacher/"+id,{
      method:'Delete',
      headers:{
        "Content-Type":"application/json",
        "Accept":"application/json",
          }
      });
      if(result.ok){
        window.location.reload(false);    

     
      }
    }

return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell align="right">Version</TableCell>
            <TableCell align="right">Firstname</TableCell>
            <TableCell align="right">Lastname</TableCell>
            <TableCell align="right"><Button 
            onClick={()=>navigate("/createTeacher")} 
            variant ="contained">Create</Button></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {teachers && teachers.map((teacher) => (
            <TableRow
              key={teacher.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="teachers">
                {teacher.id}
              </TableCell>
              <TableCell align="right">{teacher.version}</TableCell>
              <TableCell align="right">{teacher.firstname}</TableCell>
              <TableCell align="right">{teacher.lastname}</TableCell>
              <TableCell align="right"><Button variant ="contained" value={teacher.id} onClick={(e)=>deleteE(e.target.value)}>Delete</Button></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    
  );
}
export default Teacher