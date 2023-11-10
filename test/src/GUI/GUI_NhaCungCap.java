package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import ConnectDB.ConnectDB;
import DAO.NCC_DAO;
import entity.NhaCungCap;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class GUI_NhaCungCap extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtSĐT;
	private JTextField txtdiaChi;
	
	private JTextField textField_4;
	DefaultTableModel DataModel;
	JTextField txtMancc,txttenncc,txtsdt,txtdiachi;
	
	JButton bnThem,bnLuu,bnSua,bnXoa,bnXemtt;
	JLabel lblMancc,lbltenncc,lblsdt,lbldiachi,lbltinhtrang;
	JTable table;
	JButton btnThem;
	
	private NCC_DAO ncc;
	JRadioButton rdbtn_đanghđ;
	JRadioButton rdbtn_ngưnghđ;
	//private String status;
	private DefaultComboBoxModel<String> cboModelTK;
	private JComboBox<String> comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NhaCungCap frame = new GUI_NhaCungCap();
					frame.setVisible(true);
					NCC_DAO ncc=new NCC_DAO();
					new GUI_NhaCungCap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_NhaCungCap() {
		
		ConnectDB.getInstance().connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý nhà cung cấp");
		
		setBounds(100, 100, 1150, 680);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(234, 198, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 57, 70));
		panel.setBounds(0, 0, 165, 58);
		contentPane.add(panel);
		
		 JLabel lblNewLabel_1 = new JLabel("");
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(255, 255, 255));
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 lblNewLabel_1.setBackground(new Color(17, 57, 70));
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhà cung cấp");
		lblNewLabel.setForeground(new Color(234, 198, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(387, -12, 387, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setVerticalAlignment(SwingConstants.BOTTOM);
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/khachhang_img.png")));
		btnKhachHang.setForeground(new Color(255, 255, 255));
		btnKhachHang.setBackground(new Color(17, 57, 70));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			}
		});

		btnKhachHang.setBounds(0, 59, 165, 58);
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setOpaque(true);
		contentPane.add(btnKhachHang);
		
		btnKhachHang.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
	       JPopupMenu popupMenu = new JPopupMenu();
	       JMenuItem menuItemThem = new JMenuItem("Thêm khách hàng");
	        menuItemThem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThem.setForeground(new Color(255, 255, 255)); // Set text color
	        menuItemThem.setBackground(new Color(136, 74, 57)); // Set background color
	        menuItemThem.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Set font
	        menuItemThem.setPreferredSize(new Dimension(163, 58));
	        menuItemThem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
	        popupMenu.add(menuItemThem);
	        
	        JMenuItem menuItemCapNhat = new JMenuItem("Cập nhật khách hàng");
	        menuItemCapNhat.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhat.setForeground(new Color(255, 255, 255));
	        menuItemCapNhat.setBackground(new Color(136, 74, 57));
	        menuItemCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        menuItemCapNhat.setPreferredSize(new Dimension(163, 58));
	        menuItemCapNhat.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
	        popupMenu.add(menuItemCapNhat);
	        
	        JMenuItem menuItemTimKiem = new JMenuItem("Tìm khách hàng");
	        menuItemTimKiem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiem.setForeground(new Color(255, 255, 255));
	        menuItemTimKiem.setBackground(new Color(136, 74, 57));
	        menuItemTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        menuItemTimKiem.setPreferredSize(new Dimension(163, 58));
	        menuItemTimKiem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI_KhacHang guiKH = new GUI_KhacHang();
					guiKH.setVisible(true);
		            dispose();

				}
			});
	        popupMenu.add(menuItemTimKiem);

	        btnKhachHang.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Show the pop-up menu when the "Khách hàng" button is clicked
	                popupMenu.show(btnKhachHang, 0, btnKhachHang.getHeight());
	            }
	        });

	        menuItemThem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Thêm" here
	            }
	        });

	        menuItemCapNhat.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Cập nhật" here
	            }
	        });

	        menuItemTimKiem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "tìm kiếm" here
	            }
	        });
		
		JButton btnSach = new JButton("Sách\r\n");
		btnSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSach.setVerticalAlignment(SwingConstants.TOP);
		btnSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/sach_img.png")));
		btnSach.setForeground(new Color(255, 255, 255));
		btnSach.setBackground(new Color(17, 57, 70));
		btnSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSach.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnSach.setBounds(164, 59, 159, 58);
		btnSach.setContentAreaFilled(false);
		btnSach.setFocusPainted(false);
		btnSach.setOpaque(true);
		contentPane.add(btnSach);
		
		btnSach.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnSach.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnSach.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
	     JPopupMenu popupMenuSach = new JPopupMenu();
	     JMenuItem menuItemThemSach = new JMenuItem("Thêm sách");
	        menuItemThemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemThemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemThemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemThemSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemThemSach);
	        
	        JMenuItem menuItemCapNhatSach = new JMenuItem("Cập nhật sách");
	        menuItemCapNhatSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhatSach.setForeground(new Color(255, 255, 255)); 
	        menuItemCapNhatSach.setBackground(new Color(136, 74, 57));
	        menuItemCapNhatSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemCapNhatSach.setPreferredSize(new Dimension(157, 58));
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemCapNhatSach);
	        
	        JMenuItem menuItemTimKiemSach = new JMenuItem("Tìm kiếm sách");
	        menuItemTimKiemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemTimKiemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemTimKiemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemTimKiemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemTimKiemSach);
	        
	        JMenuItem menuItemXoaSach = new JMenuItem("Xóa sách");
	        menuItemXoaSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
	        menuItemXoaSach.setForeground(new Color(255, 255, 255)); 
	        menuItemXoaSach.setBackground(new Color(136, 74, 57)); 
	        menuItemXoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemXoaSach.setPreferredSize(new Dimension(157, 58));
	        menuItemXoaSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemXoaSach);
	        
	        btnSach.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent e) {
		                
	        		  popupMenuSach.show(btnSach, 0, btnSach.getHeight());
		            }
		        });
	        menuItemThemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	            }
	        });
	        popupMenuSach.add(menuItemThemSach);

	      
	       
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            }
	        });
	        popupMenuSach.add(menuItemCapNhatSach);

	      
	        
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            }
	        });
	        popupMenuSach.add(menuItemTimKiemSach);

	       
	       
	        menuItemXoaSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             
	            }
	        });
	        popupMenuSach.add(menuItemXoaSach);

	       
	        btnSach.setComponentPopupMenu(popupMenuSach);
	   

		
		
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/bill_imng.png")));
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setBackground(new Color(17, 57, 70));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHoaDon.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(322, 59, 165, 58);
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setOpaque(true);
		contentPane.add(btnHoaDon);
		
		btnHoaDon.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(17, 57, 70));
		    }
		});
		
		JPopupMenu popupMenuHoaDon = new JPopupMenu();
		JMenuItem menuItemTaoHoaDon = new JMenuItem("Tạo hóa đơn");
		menuItemTaoHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemTaoHoaDon.setForeground(new Color(255, 255, 255));
		menuItemTaoHoaDon.setBackground(new Color(136, 74, 57));
		menuItemTaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTaoHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemTaoHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_HoaDon guiHoaDon = new GUI_HoaDon();
				guiHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemTaoHoaDon);

		
		JMenuItem menuItemXemChiTietHoaDon = new JMenuItem("Xem chi tiết hóa đơn");
		menuItemXemChiTietHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/payment_img.png")));
		menuItemXemChiTietHoaDon.setForeground(new Color(255, 255, 255));
		menuItemXemChiTietHoaDon.setBackground(new Color(136, 74, 57));
		menuItemXemChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemChiTietHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_QLHD guiqlyHoaDon = new GUI_QLHD();
				guiqlyHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemXemChiTietHoaDon);


	
		btnHoaDon.setComponentPopupMenu(popupMenuHoaDon);


		btnHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		        popupMenuHoaDon.show(btnHoaDon, 0, btnHoaDon.getHeight());
		    }
		});

		menuItemTaoHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      
		    }
		});

		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/nhanvien_img.png")));
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.setBackground(new Color(17, 57, 70));
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnNhanVien.setBounds(486, 59, 165, 58);
		btnNhanVien.setContentAreaFilled(false);
		btnNhanVien.setFocusPainted(false);
		btnNhanVien.setOpaque(true);
		contentPane.add(btnNhanVien);
		
		btnNhanVien.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhanVien.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhanVien.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		JPopupMenu popupMenuNhanVien = new JPopupMenu();
		JMenuItem menuItemThemNhanVien = new JMenuItem("Thêm nhân viên");
		menuItemThemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemThemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemThemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemThemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemThemNhanVien);

		
		JMenuItem menuItemCapNhatNhanVien = new JMenuItem("Cập nhật nhân viên");
		menuItemCapNhatNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNhanVien.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNhanVien.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemCapNhatNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemCapNhatNhanVien);

		
		JMenuItem menuItemTimKiemNhanVien = new JMenuItem("Tìm nhân viên");
		menuItemTimKiemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemTimKiemNhanVien);

		
		JMenuItem menuItemXoaNhanVien = new JMenuItem("Xóa nhân viên");
		menuItemXoaNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
		menuItemXoaNhanVien.setForeground(new Color(255, 255, 255));
		menuItemXoaNhanVien.setBackground(new Color(136, 74, 57));
		menuItemXoaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemXoaNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemXoaNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemXoaNhanVien);

	
		JMenuItem menuItemXemNhanVienBiXoa = new JMenuItem("Xem nhân viên bị xóa");
		menuItemXemNhanVienBiXoa.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/erase_img.png")));
		menuItemXemNhanVienBiXoa.setForeground(new Color(255, 255, 255));
		menuItemXemNhanVienBiXoa.setBackground(new Color(136, 74, 57));
		menuItemXemNhanVienBiXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemNhanVienBiXoa.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemXemNhanVienBiXoa);

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Tạo một thể hiện của GUI_NhanVien
		        GUI_XemTTNVbixoa guiXemTTNVbixoa = new GUI_XemTTNVbixoa();

		        // Ẩn giao diện hiện tại 
		        setVisible(false);

		        // Hiển thị giao diện mới
		        guiXemTTNVbixoa.setVisible(true);
		    }
		});
		btnNhanVien.setComponentPopupMenu(popupMenuNhanVien);

		
		btnNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNhanVien.show(btnNhanVien, 0, btnNhanVien.getHeight());
		    }
		});

		menuItemThemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});

		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});

		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		 
		    }
		});

		menuItemXoaNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    
		    }
		});

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		  
		    }
		});
		
		JButton btnNhaCungCap = new JButton("Nhà cung cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/ncc_img.png")));
		btnNhaCungCap.setForeground(new Color(255, 255, 255));
		btnNhaCungCap.setBackground(new Color(17, 57, 70));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNhaCungCap.setBounds(650, 59, 165, 58);
		btnNhaCungCap.setContentAreaFilled(false);
		btnNhaCungCap.setFocusPainted(false);
		btnNhaCungCap.setOpaque(true);
		contentPane.add(btnNhaCungCap);
		
		btnNhaCungCap.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		
		JPopupMenu popupMenuNCC = new JPopupMenu();
		JMenuItem menuItemThemNCC = new JMenuItem("Thêm NCC");
		menuItemThemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNCC.setForeground(new Color(255, 255, 255));
		menuItemThemNCC.setBackground(new Color(136, 74, 57));
		menuItemThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemThemNCC);

		
		JMenuItem menuItemCapNhatNCC = new JMenuItem("Cập nhật NCC");
		menuItemCapNhatNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNCC.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNCC.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemCapNhatNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemCapNhatNCC);

	
		JMenuItem menuItemTimKiemNCC = new JMenuItem("Tìm NCC");
		menuItemTimKiemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNCC.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNCC.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemTimKiemNCC);

		
		btnNhaCungCap.setComponentPopupMenu(popupMenuNCC);

	
		btnNhaCungCap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNCC.show(btnNhaCungCap, 0, btnNhaCungCap.getHeight());
		    }
		});

		menuItemThemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemCapNhatNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemTimKiemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		    }
		});
		
		JButton btnTroGiup = new JButton("Trợ giúp");
		btnTroGiup.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/help_img.png")));
		btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroGiup.setForeground(new Color(255, 255, 255));
		btnTroGiup.setBackground(new Color(17, 57, 70));
		btnTroGiup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTroGiup.setBounds(814, 59, 165, 58);
		btnTroGiup.setContentAreaFilled(false);
		btnTroGiup.setFocusPainted(false);
		btnTroGiup.setOpaque(true);
		contentPane.add(btnTroGiup);
		
		btnTroGiup.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(17, 57, 70));
		    }
		});
		
		JPopupMenu popupMenuTrGip = new JPopupMenu();

	
		JMenuItem menuItemHuongDan = new JMenuItem("Hướng dẫn sử dụng");
		menuItemHuongDan.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/manual_img.png")));
		menuItemHuongDan.setForeground(new Color(255, 255, 255));
		menuItemHuongDan.setBackground(new Color(136, 74, 57));
		menuItemHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemHuongDan.setPreferredSize(new Dimension(163, 58));
		popupMenuTrGip.add(menuItemHuongDan);

		
		JMenuItem menuItemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		menuItemDoiMatKhau.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/reload_img.png")));
		menuItemDoiMatKhau.setForeground(new Color(255, 255, 255));
		menuItemDoiMatKhau.setBackground(new Color(136, 74, 57));
		menuItemDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemDoiMatKhau.setPreferredSize(new Dimension(163, 58));
		menuItemDoiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_DMK guiDMK = new GUI_DMK();
				guiDMK.setVisible(true);
				dispose();
				
			}
		});
		popupMenuTrGip.add(menuItemDoiMatKhau);

		
		btnTroGiup.setComponentPopupMenu(popupMenuTrGip);

	
		btnTroGiup.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		        popupMenuTrGip.show(btnTroGiup, 0, btnTroGiup.getHeight());
		    }
		});

		menuItemHuongDan.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemDoiMatKhau.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		
		    }
		});
		
		JButton btnThoat = new JButton("Thoát (Alt + 4)");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/exit_img.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(17, 57, 70));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setBounds(978, 59, 165, 58);
		btnThoat.setContentAreaFilled(false);
		btnThoat.setFocusPainted(false);
		btnThoat.setOpaque(true);
		contentPane.add(btnThoat);
		
		btnThoat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnThoat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnThoat.setBackground(new Color(17, 57, 70));
		    }
		});
		
		btnThoat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Đóng giao diện hiện tại (GUI_NhanVien)
		        dispose();

		        // Hiển thị lại giao diện GUI_TrangChu
		        GUI_TrangChu guiTrangChu = new GUI_TrangChu();
		        guiTrangChu.setVisible(true);
		    }
		});
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/logout_img.png")));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangXuat.setBackground(new Color(17, 57, 70));
		btnDangXuat.setBounds(978, 25, 158, 33);
		btnDangXuat.setContentAreaFilled(false);
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setOpaque(true);
		contentPane.add(btnDangXuat);
		
		btnDangXuat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(17, 57, 70));
		    }
		});

		btnDangXuat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		        	GUI_DangNhap lg = new GUI_DangNhap();
		            lg.setVisible(true);
		            dispose();
		        }
		    }
		});
		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(17, 57, 70));
		pnUser.setBounds(978, 0, 165, 25);
		contentPane.add(pnUser);
		pnUser.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setIcon(new ImageIcon(GUI_KhacHang.class.getResource("/imgs/user_img.png")));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(10, 0, 108, 20);
		pnUser.add(lblUser);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(107, 11, 0, 0);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1.setBackground(new Color(17, 57, 70));
		pnUser.add(lblNewLabel_1_1);
		
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lblNewLabel_1.setText("" + sdf.format(new Date()));
            }
        });
        timer.start();
        
        
		

        //Body Cần code
		
//		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp:");
//		lblMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblMaNCC.setForeground(new Color(234, 198, 150));
//		lblMaNCC.setBounds(90, 141, 151, 44);
//	contentPane.add(lblMaNCC);
        
        
        lblMancc=new JLabel("Mã nhà cung cấp:");
        lblMancc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMancc.setForeground(new Color(234, 198, 150));
        
        lblMancc.setBounds(90, 141, 151, 44);
        contentPane.add(lblMancc);
		
		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
		lblTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNCC.setForeground(new Color(234, 198, 150));
		lblTenNCC.setBounds(90, 195, 165, 44);
		contentPane.add(lblTenNCC);
		
		JLabel lblSĐT = new JLabel("SĐT:");
		lblSĐT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSĐT.setForeground(new Color(234, 198, 150));
		lblSĐT.setBounds(679, 147, 73, 32);
	contentPane.add(lblSĐT);
	
		JLabel lbldiaChi = new JLabel("ĐỊa chỉ:");
		lbldiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lbldiaChi.setForeground(new Color(234, 198, 150));
		lbldiaChi.setBounds(679, 198, 95, 38);
		contentPane.add(lbldiaChi);
	
		txtMancc = new JTextField();
		txtMancc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMancc.setBounds(248, 146, 239, 42);
		contentPane.add(txtMancc);
		txtMancc.setColumns(10);
		
		txttenncc = new JTextField();
		txttenncc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txttenncc.setColumns(10);
		txttenncc.setBounds(248, 200, 239, 42);
		contentPane.add(txttenncc);
		
		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsdt.setColumns(10);
		txtsdt.setBounds(767, 143, 239, 42);
		contentPane.add(txtsdt);
		
		txtdiachi = new JTextField();
		txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(767, 197, 239, 42);
		contentPane.add(txtdiachi);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng:");
		lblTinhTrang.setForeground(new Color(234, 198, 150));
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTinhTrang.setBounds(332, 278, 105, 32);
		contentPane.add(lblTinhTrang);
		
		
//		ButtonGroup buttonGroup = new ButtonGroup();
//		JCheckBox chkyes = new JCheckBox("Hoạt động");
//		chkyes.setOpaque(false);
//		//chkyes.setForeground(new Color(234, 198, 150));
//		//chkyes.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		chkyes.setBounds(596, 278, 165, 32);
//		contentPane.add(chkyes);
//		buttonGroup.add(chkyes);
//		
//		
//		JCheckBox chkno = new JCheckBox("Không Hoạt động");
//		chkno.setOpaque(false);
//		//chkno.setForeground(new Color(234, 198, 150));
//		//chkno.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		chkno.setBounds(469, 278, 165, 32);
//		contentPane.add(chkno);
//		buttonGroup.add(chkno);
//		
//		
//		chkyes.setPreferredSize(new Dimension(100, 20));
//		chkno.setPreferredSize(new Dimension(100, 20));
		
		
		
	ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rdbtn_đanghđ = new JRadioButton("Đang hoạt động");
		rdbtn_đanghđ.setOpaque(false);
		rdbtn_đanghđ.setForeground(new Color(234, 198, 150));
		rdbtn_đanghđ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtn_đanghđ.setBounds(469, 278, 165, 32);
		contentPane.add(rdbtn_đanghđ);		
		buttonGroup.add(rdbtn_đanghđ);

		JRadioButton rdbtn_ngưnghđ = new JRadioButton("Ngưng hoạt động");
		rdbtn_ngưnghđ.setOpaque(false);
		rdbtn_ngưnghđ.setForeground(new Color(234, 198, 150));
		rdbtn_ngưnghđ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtn_ngưnghđ.setBounds(650, 279, 187, 31);
		contentPane.add(rdbtn_ngưnghđ);
		buttonGroup.add(rdbtn_ngưnghđ);
		
		
		if (rdbtn_đanghđ != null) {
			  rdbtn_đanghđ.setSelected(true);
			}
		
		


		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 330, 1143, 186);
		//contentPane.add(scrollPane);
		

		
		
		String[] headers= "Ma NCC;Ten NCC; SDT;DiaChi;TinhTrang".split(";");
		DataModel=new DefaultTableModel(headers,0);
		
		scrollPane.setViewportView(table=new JTable(DataModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//table.setPreferredSize(new Dimension(500, 300));
		contentPane.add(scrollPane);
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				assert row >= 0;
				napLopHocVaoTextfields();
			}
		});
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(17, 57, 70));
		btnThem.setForeground(new Color(234, 198, 150));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(25, 526, 140, 44);
		contentPane.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String trangThai =rdbtn_đanghđ.isSelected() ? "Đang hoat dong" : "Ngưng hoat dong";
				if(checkEmpty()) {
					ncc.addNCC(new NhaCungCap(txtMancc.getText(), txttenncc.getText(), txtsdt.getText(), txtdiachi.getText(),trangThai));
					updateTable();
					
					
					JOptionPane.showMessageDialog(btnThem, "Thêm Thành Công!");
				
					//napLopHocVaoTextfields();
				}
				
				
			}
		});
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(new Color(17, 57, 70));
		btnCapNhat.setForeground(new Color(234, 198, 150));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(218, 526, 140, 44);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
		        if (row < 0) {
		            JOptionPane.showMessageDialog(btnCapNhat, "Vui lòng chọn một nhà cung cấp để cập nhật!");
		            return;
		        }
		        
		     // Cập nhật trạng thái của nhà cung cấp trong cơ sở dữ liệu
		        String maNCC = txtMancc.getText();
		        String tenNCC = txttenncc.getText();
		        String sdt = txtsdt.getText();
		        String diaChi = txtdiachi.getText();
		        String trangThai = rdbtn_đanghđ.isSelected() ? "Đang hoạt động" : "Ngưng hoạt động";
		        ncc.updateNCC(new NhaCungCap(maNCC, tenNCC, sdt, diaChi, trangThai));
				updateTable();
				
				 // Cập nhật bảng
				 table.setValueAt(maNCC, row, 0);
			        table.setValueAt(tenNCC, row, 1);
			        table.setValueAt(sdt, row, 2);
			        table.setValueAt(diaChi, row, 3);
			        table.setValueAt(trangThai, row, 4);
			      
		        JOptionPane.showMessageDialog(btnThem, "Chỉnh sửa thành công!");
		        
		        
			}
				
		});
		
		
		

		cboModelTK = new DefaultComboBoxModel<String>();
		comboBox = new JComboBox<String>(cboModelTK);
		comboBox.setForeground(new Color(249, 224, 187));
		comboBox.setBackground(new Color(17, 57, 70));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(702, 528, 135, 42);
		contentPane.add(comboBox);
		updateJComboBox();
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(837, 528, 142, 42);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/search_img.png")));
		btnSearch.setBackground(new Color(17, 57, 70));
		btnSearch.setBounds(978, 528, 45, 42);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnSearch) || o.equals(textField_4)) {
					xoaBang();
					if (comboBox.getSelectedIndex() == 0)
						timTheoMa();

					if (comboBox.getSelectedIndex() == 1)
						try {
							if (textField_4.getText().matches("( *)")) {
								updateTable();
								JOptionPane.showMessageDialog(null, "Nhập tên cần tìm!");
								textField_4.setText("");
								textField_4.requestFocus();

							} else {
								timTheoTen();
							}

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					if (comboBox.getSelectedIndex() == 2)
						try {
							if (textField_4.getText().matches("( *)")) {
								updateTable();
								JOptionPane.showMessageDialog(null, "Nhập số điện thoại cần tìm!");
								textField_4.setText("");
								textField_4.requestFocus();

							} else {
								timTheoSoDT();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					if (o.equals(comboBox)) {
						textField_4.selectAll();
						textField_4.requestFocus();
					}

				}
			}
		});
		
		
		
		
		
        
		
		ncc =new NCC_DAO();
		table.setRowHeight(25);
		for(NhaCungCap n:ncc.getAllNCC()) {
			//Object[] rowData= {n.getMaNCC(),n.getTenNCC(),n.getSdt(),n.getDiaChi(),n.isTinhTrang()};
			Object[] rowData= {n.getMaNCC(),n.getTenNCC(),n.getSdt(),n.getDiaChi(),n.getTinhTrang()};
			DataModel.addRow(rowData);
		}
        
        
		
		JLabel label = new JLabel("New label");
		label.setBounds(169, 72, 36, 32);
		contentPane.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("l");
		lblNewLabel_4.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/gui_ncc.png")));
		lblNewLabel_4.setBounds(0, 0, 1143, 663);
		contentPane.add(lblNewLabel_4);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setForeground(new Color(234, 198, 150));
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLmMi.setBackground(new Color(17, 57, 70));
		btnLmMi.setBounds(401, 526, 140, 44);
		contentPane.add(btnLmMi);
		btnLmMi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object o = e.getSource();
				if (o.equals(btnLmMi)) {
					try {
						lamMoi();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				}
				
				
			
		});
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	
	}
	


	
	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtMancc.setText((String) table.getValueAt(row, 0));
			txttenncc.setText((String) table.getValueAt(row, 1));
			txtsdt.setText((String) table.getValueAt(row, 2));
			txtdiachi.setText((String) table.getValueAt(row, 3));
			//rdbtn_đanghđ.setSelected((boolean) table.getValueAt(row, 4));
			String trangThai = (String) table.getValueAt(row, 4);
			rdbtn_đanghđ.setSelected(trangThai.equals("Đang hoạt động"));
		    
		}
	}
	
	private void updateTable() {
		DataModel.setRowCount(0);
		for(NhaCungCap n:ncc.getAllNCC()) {
			
				//Object[] rowData= {n.getMaNCC(),n.getTenNCC(),n.getSdt(),n.getDiaChi(),n.isTinhTrang()? "Đang hoạt động" : "Ngưng hoạt động"};
			Object[] rowData= {n.getMaNCC(),n.getTenNCC(),n.getSdt(),n.getDiaChi(),n.getTinhTrang()};
				DataModel.addRow(rowData);
				
			
		}
	}
	
	private void selecttedRow(int row) {
		if(row!=-1) {
			table.setRowSelectionInterval(row, row);
			table.scrollRectToVisible(table.getCellRect(row, row, true));
		}
	}

	
	private void updateJComboBox() {
		cboModelTK.addElement("Mã Nhà Cung Cấp");
		cboModelTK.addElement("Tên Nhà Cung Cấp");
		
	}
	
	

	
	private void xoaBang() {
		for (int j = 0; j < table.getRowCount(); j++) {
			DataModel.removeRow(j);
			j--;
		}
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	private void timTheoSoDT() throws SQLException {
		table.clearSelection();
		String soDT = textField_4.getText();
		NhaCungCap ncc = new NhaCungCap();
		NCC_DAO daoNCC = new NCC_DAO();
		ncc = daoNCC.getNCCTheoSDT(soDT);
		if (ncc == null) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy Nhà Cung Cấp! ");
		} else {

			String[] row = {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(),ncc.getDiaChi(),ncc.getTinhTrang() };
			DataModel.addRow(row);
		}
		table.setModel(DataModel);
	}

	private void timTheoTen() throws SQLException {
		table.clearSelection();
		String ten = textField_4.getText();
		NCC_DAO daoNCC = new NCC_DAO();
		List<NhaCungCap> listNCC = daoNCC.getNCCTheoTen(ten);
		if (listNCC.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy tên Nhà Cung Cấp theo ten! ");

		} else {
			for (NhaCungCap ncc : listNCC) {

				String[] row = {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(),ncc.getDiaChi(),ncc.getTinhTrang() };
				DataModel.addRow(row);
			}

			table.setModel(DataModel);
		}
	}
	
	private void timTheoMa() {
		table.clearSelection();
		String maNCC = textField_4.getText();
		NhaCungCap ncc = new NhaCungCap();
		NCC_DAO daoNCC = new NCC_DAO();
		ncc = daoNCC.getNCCTheoMa(maNCC);

		if (ncc == null) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy Nhà Cung Cấp ");
		} else {

			String[] row = {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(),ncc.getDiaChi(),ncc.getTinhTrang() };
			DataModel.addRow(row);
		}

		table.setModel(DataModel);
	}
	
	// Kiểm Tra Xác Thực 
		private Boolean checkEmpty() {
			String makh = txtMancc.getText();
			String tenkh = txttenncc.getText();
			
			;
			String diachi = txtdiachi.getText();
			String sodt = txtsdt.getText();

			if (makh.trim().equals("")) {
				return showErrorTx(txtMancc, "Mã Nhà Cung Cấp không được để trống");

			}else if (!(makh.length() > 0 && makh.matches("^(NCC)[0-9]{3}$"))) {
				JOptionPane.showMessageDialog(null, "Không đúng định dạng" + "\nVui lòng nhập theo VD: NCC001");
				txtMancc.selectAll();
				txtMancc.requestFocus();
				return false;
			} 
			else if (tenkh.trim().equals("")) {
				return showErrorTx(txttenncc,"Tên Nhà Cung Cấp không được để trống");
			}else if(!tenkh.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\"\r\n"
					+ "				+ \"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\"\r\n"
					+ "				+ \"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
				JOptionPane.showMessageDialog(this, "Nhập sai tên. Tên không chứa số hoặc các ký tự đặc biệt", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txttenncc.selectAll();
				txttenncc.requestFocus();
				return false;
				

			
			}
			else if (diachi.trim().equals("")) {
				return showErrorTx(txtdiachi,"Địa Chỉ không được để trống");
			}else if(!diachi.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
							+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
							+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ 0-9,./-]+") || diachi.length() < 0) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtdiachi.selectAll();
				txtdiachi.requestFocus();
				return false;
				
			}
			else if (sodt.trim().equals("")) {
				return showErrorTx(txtsdt, "Số điện thoại không được để trống");
			}
			else if(sodt.length() < 0 || !sodt.matches("^0[0-9]{9}")) {
				JOptionPane.showMessageDialog(this, "Số Điện Thoại Nhập Vào Không Hợp Lệ !", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
				txtsdt.selectAll();
				txtsdt.requestFocus();
				return false;
				
			}

			return true;
		}




		private Boolean showErrorTx(JTextField tx,String errorInfo) {
			JOptionPane.showMessageDialog(tx, errorInfo);
			tx.requestFocus();
			return false;
		}
		
		private void lamMoi() throws SQLException {
			textField_4.setText("");
			comboBox.setSelectedIndex(0);
			xoaBang();
			updateTable();
		}
}
